package dat.backend.model.persistence;

import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BalanceMapper {

    static User getBalance(ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        User user = null;

        String sql = "SELECT * FROM user";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String role = rs.getString("role");
                    int balance = rs.getInt("balance");
                    String password = rs.getString("password");
                    String email = rs.getString("email");
                    user = new User(email, password, role, balance);
                } else {
                    throw new DatabaseException("Could not get user information");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Error getting user information. Something went wrong with the database");
        }
        return user;
    }

    // Her skal jeg lave en funktion hvor man sætter en Balance (penge ind hos brugeren)!!!


    static User createBalance(int balance, String email, ConnectionPool connectionPool) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");
        User user = null;

        String sql = "insert into user (balance) values (?) where ";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, balance);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1)
                {
                    user = new User(email, password, role, 0); //her skal der gøres noget
                } else
                {
                    throw new DatabaseException("The user with email = " + email + " could not get an updated balance");
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

