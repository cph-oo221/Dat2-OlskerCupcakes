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

@WebServlet(name = "Purchase", value = "/purchase")
public class Purchase extends HttpServlet
{
    ConnectionPool connectionPool;

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
        User user = (User) request.getSession().getAttribute("user");
        int idReceipt = Integer.parseInt(request.getParameter("idReceipt"));
        int total = Integer.parseInt(request.getParameter("total"));

        String msg = "";
        try
        {
            if (Facade.purchase(user,idReceipt, total, connectionPool))
            {
               request.getSession().setAttribute("msg", msg);
               request.getRequestDispatcher("WEB-INF/confirmed.jsp").forward(request, response);
            }
            else
            {
                msg = "Purchase denied. Not enough funds";
                request.getSession().setAttribute("msg", msg);
                response.sendRedirect("userpage");
            }
        }
        catch (DatabaseException e)
        {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
