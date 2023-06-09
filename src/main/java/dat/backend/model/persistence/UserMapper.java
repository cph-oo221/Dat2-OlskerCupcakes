package dat.backend.model.persistence;

import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class UserMapper
{
    static User login(String email, String password, ConnectionPool connectionPool) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");

        User user;

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
                    int iduser = rs.getInt("iduser");
                    user = new User(iduser, email, password, role, balance);
                }
                else
                {
                    throw new DatabaseException("Wrong username or password");
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Error logging in. Something went wrong with the database");
        }
        return user;
    }

    static User createUser(String email, String password, String role, ConnectionPool connectionPool) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");
        User user = getUserByEmail(email, connectionPool);

        if (user != null)
        {
            throw new DatabaseException("User already exists");
        }

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
                    ps.close();
                    sql = "SELECT LAST_INSERT_ID();";
                    try (PreparedStatement psid = connection.prepareStatement(sql))
                    {
                        ResultSet rs = psid.executeQuery();
                        if (rs.next())
                        {
                            int iduser = rs.getInt("LAST_INSERT_ID()");
                            user = new User(iduser, email, password, role, 0);
                        } else
                        {
                            throw new DatabaseException("No key found in resultset");
                        }
                    }
                }
                else
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

    private static User getUserByEmail(String email, ConnectionPool connectionPool) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "checking if user exists");
        String sql = "SELECT * FROM user WHERE email = ?;";

        try (Connection connection = connectionPool.getConnection())
        {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
            {
                int idUser = rs.getInt("idUser");
                String password = rs.getString("password");
                String role = rs.getString("role");
                int balance = rs.getInt("balance");

              return new User(idUser, email, password, role, balance);
            }
            return null;
        }
        catch (SQLException e)
        {
            throw new DatabaseException(e.getMessage());
        }
    }

    static List<User> getAllUsers(ConnectionPool connectionPool) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    String role = rs.getString("role");
                    int balance = rs.getInt("balance");
                    int iduser = rs.getInt("iduser");
                    User user = new User(iduser, email, password, role, balance);
                    userList.add(user);
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Error logging in. Something went wrong with the database");
        }
        return userList;
    }

    static void updateBalance(int idUser, int balance, ConnectionPool connectionPool) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "update user set balance = ? where idUser = ?";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, balance);
                ps.setInt(2, idUser);

                int rowsAffected = ps.executeUpdate();

            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Could not insert balance into database");
        }
    }

    static boolean purchase(User user, int price, ConnectionPool connectionPool)
    {
        Logger.getLogger("web").log(Level.INFO, "");
        int idUser = user.getIdUser();

        String sql = "SELECT balance FROM user WHERE idUser = ?";
        int balance = -1;

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, idUser);
                ResultSet rs = ps.executeQuery();

                if (rs.next())
                {
                    balance = rs.getInt("balance");
                }
            }
            catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
            if (balance > -1)
            {
                if (price <= balance)
                {
                    int newBalance = balance - price;
                    updateBalance(idUser, newBalance, connectionPool);
                    user.setBalance(newBalance);
                    return true;

                }
                else
                {
                    return false;
                }
            }
            else
            {
                throw new DatabaseException("Couldn't get balance from database");
            }

        }
        catch (DatabaseException | SQLException e)
        {
            e.printStackTrace();
        }
        return false; //Should never happen / You fucked up biiig
    }
}
