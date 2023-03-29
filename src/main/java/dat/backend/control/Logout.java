package dat.backend.control;

import dat.backend.model.entities.OrderItem;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "logout", urlPatterns = {"/logout"} )
public class Logout extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        Browse.setOrderItemList(new ArrayList<>());

        session.setAttribute("orderItemList", new ArrayList<OrderItem>());
        session.setAttribute("user", null);

        session.invalidate();
        response.sendRedirect("index.jsp");
    }
}