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

@WebServlet(name = "DeleteReceipt", value = "/deleteReceipt")
public class DeleteReceipt extends HttpServlet
{
    ConnectionPool connectionPool = ApplicationStart.getConnectionPool();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int idReceipt = Integer.parseInt(request.getParameter("idReceipt"));
        try
        {
            int rowsaffected = Facade.deleteReceipt(idReceipt, connectionPool);
        }
        catch (DatabaseException e)
        {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

        User user = (User) request.getSession().getAttribute("user");
        if(user.getRole().equalsIgnoreCase("user"))
        {
            response.sendRedirect("userpage");
        }
        else if(user.getRole().equalsIgnoreCase("admin"))
        {
            response.sendRedirect("Receipts");
        }
    }
}
