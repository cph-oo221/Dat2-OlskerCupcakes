package dat.backend.model.persistence;

import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class UserMapper
{
    static User login(String email, String password, ConnectionPool connectionPool) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");

        User user = null;

        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    String role = rs.getString("role");
                    int balance = rs.getInt("balance");
                    user = new User(email, password, role, balance);
                } else
                {
                    throw new DatabaseException("Wrong username or password");
                }
            }
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Error logging in. Something went wrong with the database");
        }
        return user;
    }

    static User createUser(String email, String password, String role, ConnectionPool connectionPool) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");
        User user = null;
        String sql = "insert into user (email, password, role) values (?,?,?)";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, email);
                ps.setString(2, password);
                ps.setString(3, role);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1)
                {
                    user = new User(email, password, role, 0);
                } else
                {
                    throw new DatabaseException("The user with email = " + email + " could not be inserted into the database");
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Could not insert username into database");
        }
        return user;
    }

    static User updateBalance(String email, int balance ,ConnectionPool connectionPool)throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");

        User user = null; // her skal jeg have den user der er knyttet til email.

        String sql = "insert into user (balance) values (?)";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {

                ps.setInt(2, balance);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1)
                {
                    //her skal user have ny balance 
                } else
                {
                    throw new DatabaseException("The user with email = " + email + " could not have new balance added into the database");
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Could not insert balance into database");
        }


        return user;
    }




}
