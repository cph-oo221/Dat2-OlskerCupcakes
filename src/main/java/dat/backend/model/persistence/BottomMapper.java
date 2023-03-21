package dat.backend.model.persistence;

import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.Top;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BottomMapper {
    static Bottom getBottom(String name, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        Bottom bottom = null;

        String sql = "SELECT * FROM Bottom WHERE name = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, name);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int idBottom = rs.getInt("idBottom");
                    String BottomName = rs.getString("name");
                    int price = rs.getInt("price");
                    bottom = new Bottom(idBottom, name, price);
                } else {
                    throw new DatabaseException("No Bottom is named that");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Error getting bottom. Something went wrong with the database");
        }
        return bottom;
    }


    static ArrayList<Bottom> getAllBottoms(ConnectionPool connectionPool) throws DatabaseException {
        ArrayList<Bottom> bottomList = new ArrayList<>();
        Logger.getLogger("web").log(Level.INFO, "");

        Bottom bottom;

        String sql = "SELECT * FROM bottom";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int idBottom = rs.getInt("idBottom");
                    String name = rs.getString("name");
                    int price = rs.getInt("price");
                    bottom = new Bottom(idBottom, name, price);
                    bottomList.add(bottom);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Error getting bottom. Something went wrong with the database");
        }
        return bottomList;
    }
}