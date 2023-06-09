package dat.backend.model.persistence;

import dat.backend.model.entities.Top;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TopMapper
{
    static Top getTop(String name, ConnectionPool connectionPool) throws DatabaseException, SQLException
    {
        Logger.getLogger("web").log(Level.INFO, "");

        Top top;

        String sql = "SELECT * FROM top WHERE name = ?";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, name);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    int idTop = rs.getInt("idTop");
                    int price = rs.getInt("price");
                    top = new Top(idTop, name, price);
                }
                else
                {
                    throw new DatabaseException("No top is named that");
                }
            }
            catch (SQLException ex)
            {
                throw new DatabaseException(ex, "Error getting top. Something went wrong with the database");
            }
        }
        return top;
    }

    static Top getTopById(int idTop, ConnectionPool connectionPool) throws DatabaseException, SQLException
    {
        Logger.getLogger("web").log(Level.INFO, "");

        Top top;

        String sql = "SELECT * FROM top WHERE idTop = ?";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, idTop);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    String topName = rs.getString("name");
                    int price = rs.getInt("price");
                    top = new Top(idTop, topName, price);
                }
                else
                {
                    throw new DatabaseException("No top is named that");
                }
            }
            catch (SQLException ex)
            {
                throw new DatabaseException(ex, "Error getting top. Something went wrong with the database");
            }
        }
        return top;
    }


    static ArrayList<Top> getAllTops(ConnectionPool connectionPool) throws DatabaseException
    {
        ArrayList<Top> topList = new ArrayList<>();
        Logger.getLogger("web").log(Level.INFO, "");

        Top top;

        String sql = "SELECT * FROM top";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int idTop = rs.getInt("idTop");
                    String name = rs.getString("name");
                    int price = rs.getInt("price");
                    top = new Top(idTop, name, price);
                    topList.add(top);
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Error getting top. Something went wrong with the database");
        }
        return topList;
    }
}