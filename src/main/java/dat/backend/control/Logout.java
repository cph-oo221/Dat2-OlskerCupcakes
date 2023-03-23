package dat.backend.control;

import dat.backend.model.entities.OrderItem;
import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.ServletException;
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
        System.out.println("her");
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("orderItemList"));
        Browse.setOrderItemList(new ArrayList<>());

        session.setAttribute("orderItemList", new ArrayList<OrderItem>());
        System.out.println(session.getAttribute("orderItemList"));
        session.setAttribute("user", null);

        session.invalidate();
        response.sendRedirect("index.jsp");
    }
}