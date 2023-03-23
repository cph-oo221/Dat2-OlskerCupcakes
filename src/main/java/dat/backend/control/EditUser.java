package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.Facade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditUser", value = "/EditUser")
public class EditUser extends HttpServlet
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
        String email = request.getParameter("Email");
        int balance = Integer.parseInt(request.getParameter("balance"));
        int userId = Integer.parseInt(request.getParameter("UserId"));
        String password = request.getParameter("Password");
        String role = request.getParameter("Role");

        request.setAttribute("editUser", email);
        request.setAttribute("balance", balance);
        request.setAttribute("userId", userId);
        request.setAttribute("password", password);
        request.setAttribute("role", role);

        try
        {
            Facade.updateBalance(userId,balance,connectionPool);
        }
        catch (DatabaseException e)
        {
            e.printStackTrace();
        }

        request.getRequestDispatcher("WEB-INF/adminEdit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String email = request.getParameter("Email");
        int balance = Integer.parseInt(request.getParameter("Balance"));
        int userId = Integer.parseInt(request.getParameter("UserId"));
        String password = request.getParameter("Password");
        String role = request.getParameter("Role");

        request.setAttribute("editUser", email);
        request.setAttribute("balance", balance);
        request.setAttribute("password", password);
        request.setAttribute("role", role);
        request.setAttribute("userId", userId);

        request.getRequestDispatcher("WEB-INF/adminEdit.jsp").forward(request, response);
    }
}
