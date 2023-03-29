package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.OrderItem;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.Facade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Orders", value = "/Orders")
public class Orders extends HttpServlet
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
        int idReceipt = Integer.parseInt(request.getParameter("idReceipt"));
        boolean complete = Boolean.parseBoolean(request.getParameter("complete"));

        ArrayList<OrderItem> orderItems = null;
        try
        {
            orderItems = (ArrayList<OrderItem>) Facade.getOrderByReceiptId(idReceipt,connectionPool);
        }
        catch (DatabaseException e)
        {
           request.setAttribute("errormessage", e.getMessage());
           request.getRequestDispatcher("error.jsp").forward(request, response);
        }

        int total=0;
        for(OrderItem orderItem : orderItems)
        {
            total += orderItem.getTotalPrice();
        }

        request.setAttribute("orderItems", orderItems);
        request.setAttribute("total", total);
        request.setAttribute("idReceipt", idReceipt);
        request.setAttribute("complete",complete);

        request.getRequestDispatcher("WEB-INF/orders.jsp").forward(request, response);
    }
}
