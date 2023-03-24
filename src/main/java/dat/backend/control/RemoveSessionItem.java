package dat.backend.control;

import dat.backend.model.entities.OrderItem;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RemoveSessionItem", value = "/removesessionitem")
public class RemoveSessionItem extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
       String orderitemstring = request.getParameter("orderitemstring");
       List<OrderItem> orderItemList = (List<OrderItem>) request.getSession().getAttribute("orderItemList");

        for (OrderItem item: orderItemList)
        {
            if (orderitemstring.equals(item.toString()))
            {
                orderItemList.remove(item);
                break;
            }
        }

        response.sendRedirect("browse");
    }
}
