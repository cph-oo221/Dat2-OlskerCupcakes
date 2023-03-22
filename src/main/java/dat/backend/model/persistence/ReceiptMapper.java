package dat.backend.model.persistence;

import com.mysql.cj.protocol.Resultset;
import dat.backend.model.entities.OrderItem;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReceiptMapper {
    static Receipt getReceipt(int iduser, ConnectionPool connectionPool) throws DatabaseException, SQLException {
        Logger.getLogger("web").log(Level.INFO, "");

        Receipt receipt = null;

        String sql = "SELECT * FROM receipt WHERE iduser = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, iduser);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    Timestamp timeOfOrder = rs.getTimestamp("timeOfOrder");
                    Boolean completed = rs.getBoolean("completed");
                    receipt = new Receipt(iduser, timeOfOrder, completed);
                } else {
                    throw new DatabaseException("No receipts on this user");
                }
            } catch (SQLException ex) {
                throw new DatabaseException(ex, "Error getting receipt. Something went wrong with the database");
            }
        }
        return receipt;
    }


    static ArrayList<Receipt> getAllReceipts(ConnectionPool connectionPool) throws DatabaseException {
        ArrayList<Receipt> receiptList = new ArrayList<>();
        Logger.getLogger("web").log(Level.INFO, "");

        Receipt receipt = null;

        String sql = "SELECT * FROM receipt";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int iduser = rs.getInt("iduser");
                    Timestamp timeOfOrder = rs.getTimestamp("timeOfOrder");
                    Boolean completed = rs.getBoolean("completed");
                    receipt = new Receipt(iduser, timeOfOrder, completed);
                    receiptList.add(receipt);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Error getting receipts. Something went wrong with the database");
        }
        return receiptList;
    }

    static void createReceipt(int iduser, List<OrderItem> orderItemList, ConnectionPool connectionPool) throws Exception {
        Logger.getLogger("web").log(Level.INFO, "");
        Receipt receipt;
        String sql = "insert into receipt (iduser) values (?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, iduser);
                ps.executeUpdate(sql);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    sql = "SELECT LAST_INSERT_ID()";
                    try (PreparedStatement psSelect = connection.prepareStatement(sql)) {
                        ResultSet rs = psSelect.executeQuery();
                        int idReceipt = rs.getInt(1);
                        if (orderItemList.size() > 0) {
                            for (OrderItem orderItem : orderItemList) {
                                int idTop = orderItem.getTop().getIdTop();
                                int idBottom = orderItem.getBottom().getIdBottom();
                                int amount = orderItem.getAmount();
                                sql = "INSERT INTO orders (idReceipt, idTop, idBottom, amount) values (?,?,?,?)";
                                try (PreparedStatement psInsertOrders = connection.prepareStatement(sql)) {
                                    psInsertOrders.setInt(1, idReceipt);
                                    psInsertOrders.setInt(2, idTop);
                                    psInsertOrders.setInt(3, idBottom);
                                    psInsertOrders.setInt(4, amount);
                                    psInsertOrders.executeUpdate();
                                } catch (SQLException e) {
                                    throw new SQLException("The orderItem with the top " + orderItem.getTop().getIdTop() + " and bottom " + orderItem.getBottom().getIdBottom() + " could not be added");
                                }
                            }
                        } else {
                            throw new Exception("The orderItemList is empty");
                        }
                    }
                }
                else{
                    throw new DatabaseException("The receipt with iduser = " +iduser  + " could not be inserted into the database");
                }
            } catch (SQLException ex) {
                throw new DatabaseException(ex, "Could not insert top into database");
            }
        }
    }
}