package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.Facade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AdminPanel", value = "/AdminPanel")
public class AdminPanel extends HttpServlet
{
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // When in admin edit, you can change get back to admin panel
        ArrayList<User> userList = null;
        try
        {
            userList = (ArrayList<User>) Facade.getAllUsers(connectionPool);
        } catch (DatabaseException e)
        {
            e.printStackTrace();
        }
        request.setAttribute("userList", userList);

        request.getRequestDispatcher("WEB-INF/adminPanel.jsp").forward(request, response);
    }
}
