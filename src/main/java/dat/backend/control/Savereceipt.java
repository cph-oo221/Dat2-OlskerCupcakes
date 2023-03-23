package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.OrderItem;
import dat.backend.model.entities.User;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.Facade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Savereceipt", value = "/savereceipt")
public class Savereceipt extends HttpServlet
{
    ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // TODO: Create receipt and save to database
        User user = (User) request.getSession().getAttribute("user");

        if (user != null)
        {
            List<OrderItem> orderItemList = (List<OrderItem>) request.getSession().getAttribute("orderItemList");
            int idReceipt;

            try
            {
                idReceipt = Facade.createReceipt(user.getIdUser(), orderItemList, connectionPool);

                // TODO: GET FROM DB
                orderItemList = Facade.getOrderByReceiptId(idReceipt, connectionPool);

                request.setAttribute("orderItemList", orderItemList);
                request.getRequestDispatcher("WEB-INF/shoppingcart.jsp").forward(request, response);
            }
            catch (Exception throwables)
            {
                throwables.printStackTrace();
            }

        } else
        {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
