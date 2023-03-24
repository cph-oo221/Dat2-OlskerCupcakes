package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.OrderItem;
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

        ArrayList<OrderItem> orderItems = (ArrayList<OrderItem>) Facade.getOrderByReceiptId(idReceipt,connectionPool);

        int total=0;
        for(OrderItem orderItem : orderItems)
        {
            total += orderItem.getTotalPrice();
        }

        request.setAttribute("orderItems", orderItems);
        request.setAttribute("total", total);
        request.setAttribute("idReceipt", idReceipt);

        request.getRequestDispatcher("WEB-INF/orders.jsp").forward(request, response);
    }
}
