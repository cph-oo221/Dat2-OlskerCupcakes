package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.OrderItem;
import dat.backend.model.entities.Top;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.Facade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Browse", value = "/browse")
public class Browse extends HttpServlet
{
    ConnectionPool connectionPool = ApplicationStart.getConnectionPool();
    static List<OrderItem> orderItemList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ArrayList<Top> tops = new ArrayList<>();
        ArrayList<Bottom> bottoms = new ArrayList<>();
        try
        {
            tops = Facade.getTops(connectionPool);
            bottoms =  Facade.getBottoms(connectionPool);
        }
        catch (DatabaseException e)
        {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

        request.getSession().setAttribute("tops", tops);
        request.getSession().setAttribute("bottoms", bottoms);
        request.getSession().setAttribute("orderItemList", orderItemList);

        request.getRequestDispatcher("WEB-INF/browse.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    public static void setOrderItemList(List<OrderItem> orderItemListtemp)
    {
        orderItemList = orderItemListtemp;
    }
}
