package dat.backend.model.persistence;


import dat.backend.model.entities.*;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

// Behold! the eternal gate of all data!

public class Facade
{
    // User *************************
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
    // ************************************

    // Bottom *****************************
    public static ArrayList<Bottom> getBottoms(ConnectionPool connectionPool) throws DatabaseException {

         return BottomMapper.getAllBottoms(connectionPool);

        /*ArrayList<Bottom> bottoms = new ArrayList<>();
        bottoms.add(new Bottom(1, "ChocolateTest", 5));
        bottoms.add(new Bottom(2, "VanillaTest", 5));
        bottoms.add(new Bottom(3, "NutmegTest", 5));
        return bottoms;*/

    }

    public static Bottom getBottomById(int idBottom, ConnectionPool connectionPool) throws SQLException, DatabaseException {
        return BottomMapper.getBottomById(idBottom,connectionPool);

       // return new Bottom(1, "Chocolate", 5);
    }
    // ************************************


    // Top ********************************
    public static ArrayList<Top> getTops(ConnectionPool connectionPool) throws DatabaseException {

         return TopMapper.getAllTops(connectionPool);

       /* ArrayList<Top> tops = new ArrayList<>();
        tops.add(new Top(1, "ChocolateTest", 5));
        tops.add(new Top(2, "BlueberryTest", 5));
        tops.add(new Top(3, "RaspberryTest", 5));
        return tops;*/
    }

    public static Top getTopById(int idTop, ConnectionPool connectionPool) throws SQLException, DatabaseException {
        return TopMapper.getTopById(idTop,connectionPool);

       // return new Top(1, "Chocolate", 5);
    }
    // ************************************


    // Receipt ****************************
    public static Receipt getReceiptById(int idReceipt, ConnectionPool connectionPool)
    {
        // TODO: TESTING METHOD, IMPLEMENT DB

        return new Receipt(4, false);
    }

    public static List<OrderItem> getOrderByReceiptId(int idReceipt, ConnectionPool connectionPool)
    {
        // TODO: TESTING METHOD, IMPLEMENT DB

        return null;
    }

    public static int createReceipt(int idUser, List<OrderItem> orderItemList, ConnectionPool connectionPool) throws Exception
    {
        return ReceiptMapper.createReceipt(idUser, orderItemList, connectionPool);
    }
    // ************************************

    public static List<User> getAllUsers(ConnectionPool connectionPool) throws DatabaseException
    {
        return UserMapper.getAllUsers(connectionPool);
    }

    public static List<Receipt> getAllReceipts(ConnectionPool connectionPool)
    {
        List<Receipt> receipts = new ArrayList<>();

        receipts.add(new Receipt(14, false));
        receipts.add(new Receipt(12, true));
        receipts.add(new Receipt(23, false));
        receipts.add(new Receipt(1, true));
        receipts.add(new Receipt(4, false));

        return receipts;
    }
}
