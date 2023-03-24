package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.OrderItem;
import dat.backend.model.entities.Receipt;
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
        User user = (User) request.getSession().getAttribute("user");

        if (user != null)
        {
            List<OrderItem> orderItemList = (List<OrderItem>) request.getSession().getAttribute("orderItemList");
            int idReceipt;

            try
            {
                if (orderItemList.size() > 0)
                {
                    Facade.createReceipt(user.getIdUser(), orderItemList, connectionPool);
                    List<Receipt> receiptList = Facade.getReceiptsByIdUser(user.getIdUser(), connectionPool);
                    request.setAttribute("receiptList", receiptList);
                    request.getRequestDispatcher("WEB-INF/userpage.jsp").forward(request, response);
                }

                else
                {
                    request.setAttribute("msg", "Order must consist of at least 1 item");
                    request.getRequestDispatcher("WEB-INF/browse.jsp").forward(request, response);
                }
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
