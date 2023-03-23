package dat.backend.control;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Orders", value = "/Orders")
public class Orders extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int idReceipt = Integer.parseInt(getInitParameter("idReceipt"));

        request.setAttribute("idReceipt", idReceipt);

        request.getRequestDispatcher("WEB-INF/orders.jsp").forward(request, response);
    }
}
