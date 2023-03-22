package dat.backend.model.persistence;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Top;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TopMapper
{
    static Top getTop(String name, ConnectionPool connectionPool) throws DatabaseException, SQLException {
        Logger.getLogger("web").log(Level.INFO, "");

        Top top = null;

        String sql = "SELECT * FROM top WHERE name = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, name);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int idTop = rs.getInt("idTop");
                    String Topname = rs.getString("name");
                    int price = rs.getInt("price");
                    top = new Top(idTop, name, price);
                } else {
                    throw new DatabaseException("No top is named that");
                }
            } catch (SQLException ex) {
                throw new DatabaseException(ex, "Error getting top. Something went wrong with the database");
            }
        }
            return top;
    }


    static ArrayList<Top> getAllTops(ConnectionPool connectionPool) throws DatabaseException {
        ArrayList<Top> topList = new ArrayList<>();
        Logger.getLogger("web").log(Level.INFO, "");

        Top top = null;

        String sql = "SELECT * FROM top";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                        int idTop = rs.getInt("idTop");
                        String name = rs.getString("name");
                        int price = rs.getInt("price");
                        top = new Top(idTop, name, price);
                        topList.add(top);
                    }
                }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Error getting top. Something went wrong with the database");
        }
        return topList;
    }

    static Top createTop(String name, int price, ConnectionPool connectionPool) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");
        Top top;
        String sql = "insert into top (name, price) values (?, ?)";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, name);
                ps.setInt(2, price);
                ResultSet rs = ps.executeQuery(sql);
                rs.close();
                int rowsAffected = ps.executeUpdate();
                sql = "SELECT * FROM top WHERE name= (?)";
                try (PreparedStatement psSelect = connection.prepareStatement(sql)) {
                    rs = psSelect.executeQuery();
                    int idTop = rs.getInt("idTop");
                    if (rowsAffected == 1) {
                        top = new Top(idTop, name, price);
                    } else {
                        throw new DatabaseException("The top with name = " + name + " could not be inserted into the database");
                    }
                }
            }
        }

        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Could not insert top into database");
        }
        return top;
    }


}