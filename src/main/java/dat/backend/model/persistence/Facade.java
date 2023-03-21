package dat.backend.model.persistence;


import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.Top;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.util.ArrayList;

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
    // ************************************

    // Bottom *****************************
    public static ArrayList<Bottom> getBottoms()
    {
        // TODO: TESTING METHOD, IMPLEMENT DB
        //return BottomMapper.getAllBottoms(ConnectionPool connectionPool);

        ArrayList<Bottom> bottoms = new ArrayList<>();
        bottoms.add(new Bottom(1, "ChocolateTest", 5));
        bottoms.add(new Bottom(2, "VanillaTest", 5));
        bottoms.add(new Bottom(3, "NutmegTest", 5));
        return bottoms;
    }

    // Top ********************************
    public static ArrayList<Top> getTops()
    {
        // TODO: TESTING METHOD IMPLEMENT DB

        //return TopMapper.getAllTops(ConnectionPool connectionPool);

        ArrayList<Top> tops = new ArrayList<>();
        tops.add(new Top(1, "ChocolateTest", 5));
        tops.add(new Top(2, "BlueberryTest", 5));
        tops.add(new Top(3, "RaspberryTest", 5));
        return tops;
    }
    // ************************************
}
