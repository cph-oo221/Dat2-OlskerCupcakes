package dat.backend.model.persistence;


import dat.backend.model.entities.*;
import dat.backend.model.exceptions.DatabaseException;
import org.junit.jupiter.api.Order;

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

    public static void createReceipt(int idUser, List<OrderItem> orderItemList, ConnectionPool connectionPool)
    {

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

    public static Bottom getBottomById(int idBottom, ConnectionPool connectionPool)
    {
        // TODO: TESTING METHOD, IMPLEMENT DB

        return new Bottom(1, "Chocolate", 5);
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

    public static Top getTopById(int idTop, ConnectionPool connectionPool)
    {
        // TODO: TESTING METHOD, IMPLEMENT DB

        return new Top(1, "Chocolate", 5);
    }
    // ************************************

    // Receipt ****************************

    public static Receipt getReceiptById(int idReceipt, ConnectionPool connectionPool)
    {
        // TODO: TESTING METHOD, IMPLEMENT DB

        return new Receipt(4, false);
    }

    public static List<OrderItem> getOrderByReceiptId(int dReceipt, ConnectionPool connectionPool)
    {
        // TODO: TESTING METHOD, IMPLEMENT DB

        return null;
    }
    // ************************************
}
