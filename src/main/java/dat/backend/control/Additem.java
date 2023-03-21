package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.OrderItem;
import dat.backend.model.entities.Top;
import dat.backend.model.entities.User;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.Facade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Additem", value = "/additem")
public class Additem extends HttpServlet
{
    ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int idBottom = Integer.parseInt(request.getParameter("idBottom"));
        int idTop = Integer.parseInt(request.getParameter("idTop"));
        int amount = Integer.parseInt(request.getParameter("amount"));

        Bottom bottom = Facade.getBottomById(idBottom, connectionPool);
        Top top = Facade.getTopById(idTop, connectionPool);

        OrderItem orderItem = new OrderItem(bottom, top, amount);

//        User user = (User) request.getSession().getAttribute("user");
//        user.addOrderItem(orderItem);

        List<OrderItem> orderItemList = (List<OrderItem>) request.getSession().getAttribute("orderItemList");
        orderItemList.add(orderItem);

        request.getRequestDispatcher("WEB-INF/browse.jsp").forward(request, response);
    }
}
