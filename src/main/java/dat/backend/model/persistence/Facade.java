package dat.backend.model.persistence;


import dat.backend.model.entities.*;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Behold! the eternal gate of all data!

public class Facade
{
    // User ************************************************************************************************************
    public static User login(String username, String password, ConnectionPool connectionPool) throws DatabaseException
    {
        return UserMapper.login(username, password, connectionPool);
    }


    public static User createUser(String username, String password, String role, ConnectionPool connectionPool) throws DatabaseException
    {
        return UserMapper.createUser(username, password, role, connectionPool);
    }

    public static void updateBalance(int idUser, int balance, ConnectionPool connectionPool) throws DatabaseException
    {
        UserMapper.updateBalance(idUser, balance, connectionPool);
    }

    public static List<User> getAllUsers(ConnectionPool connectionPool) throws DatabaseException
    {
        return UserMapper.getAllUsers(connectionPool);
    }

    public static List<Receipt> getReceiptsByIdUser(int idUser, ConnectionPool connectionPool) throws DatabaseException
    {
        try
        {
            return ReceiptMapper.getReceiptsByIdUser(idUser,connectionPool);
        }
        catch (SQLException e)
        {
            throw new DatabaseException(e.getMessage());
        }
    }
    // ****************************************************************************************************************

    // Bottom *********************************************************************************************************
    public static ArrayList<Bottom> getBottoms(ConnectionPool connectionPool) throws DatabaseException
    {
        return BottomMapper.getAllBottoms(connectionPool);
    }

    public static Bottom getBottomById(int idBottom, ConnectionPool connectionPool) throws DatabaseException
    {
        try
        {
            return BottomMapper.getBottomById(idBottom,connectionPool);
        }
        catch (SQLException e)
        {
            throw new DatabaseException(e.getMessage());
        }
    }
    // ****************************************************************************************************************


    // Top ************************************************************************************************************
    public static ArrayList<Top> getTops(ConnectionPool connectionPool) throws DatabaseException
    {
         return TopMapper.getAllTops(connectionPool);
    }

    public static Top getTopById(int idTop, ConnectionPool connectionPool) throws DatabaseException
    {
        try
        {
            return TopMapper.getTopById(idTop,connectionPool);
        }
        catch (SQLException e)
        {
            throw new DatabaseException(e.getMessage());
        }
    }
    // ****************************************************************************************************************


    // Receipt ********************************************************************************************************
    public static Receipt getReceiptById(int idReceipt, ConnectionPool connectionPool) throws DatabaseException
    {
        try
        {
            return ReceiptMapper.getReceiptById(idReceipt,connectionPool);
        }
        catch (SQLException e)
        {
            throw new DatabaseException(e.getMessage());
        }
    }

    public static List<OrderItem> getOrderByReceiptId(int idReceipt, ConnectionPool connectionPool) throws DatabaseException
    {
        try
        {
           return OrderMapper.getOrderByReceiptId(idReceipt, connectionPool);
        }
        catch (SQLException e)
        {
            throw new DatabaseException(e.getMessage());
        }
    }

    public static int createReceipt(int idUser, List<OrderItem> orderItemList, ConnectionPool connectionPool) throws DatabaseException
    {
        try
        {
            return ReceiptMapper.createReceipt(idUser, orderItemList, connectionPool);
        }
        catch (SQLException e)
        {
            throw new DatabaseException(e.getMessage());
        }
    }

    public static List<Receipt> getAllReceipts(ConnectionPool connectionPool) throws DatabaseException
    {
        return ReceiptMapper.getAllReceipts(connectionPool);
    }

    public static boolean purchase(User user , int idReceipt , int price , ConnectionPool connectionPool) throws DatabaseException
    {
        if (UserMapper.purchase(user , price , connectionPool))
        {
            ReceiptMapper.toggleReceipt(idReceipt, connectionPool);
            return true;
        }
        return false;
    }

    public static int deleteAllOrdersFromReceipt(int idReceipt, ConnectionPool connectionPool) throws DatabaseException
    {
        try
        {
            return OrderMapper.deleteAllOrdersFromReceipt(idReceipt, connectionPool);
        }
        catch (SQLException e)
        {
            throw new DatabaseException(e.getMessage());
        }
    }

    public static int deleteReceipt(int idReceipt, ConnectionPool connectionPool) throws DatabaseException
    {
        return ReceiptMapper.deleteReceipt(idReceipt, connectionPool);
    }
    // ****************************************************************************************************************
}
