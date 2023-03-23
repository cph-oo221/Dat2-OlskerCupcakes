package dat.backend.model.persistence;

import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.OrderItem;
import dat.backend.model.entities.Top;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderMapper {
    static List<OrderItem> getOrderByReceiptId(int idReceipt, ConnectionPool connectionPool) throws DatabaseException, SQLException {
        Logger.getLogger("web").log(Level.INFO, "");

        List<OrderItem> orderItemList = new ArrayList<>();

        String sql = "SELECT idTop, idBottom, amount FROM order WHERE idReceipt = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, idReceipt);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int idTop = rs.getInt("idTop");
                    int idBottom = rs.getInt("idBottom");
                    int amount= rs.getInt("amount");
                    Top top = Facade.getTopById(idTop, connectionPool);
                    Bottom bottom = Facade.getBottomById(idTop, connectionPool);
                    OrderItem orderItem = new OrderItem(bottom, top, amount);
                    orderItemList.add(orderItem);
                }
                return orderItemList;
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Error getting top. Something went wrong with the database");
        }
    }
}
