package dat.backend.control;

import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.OrderItem;
import dat.backend.model.entities.Top;
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
    List<OrderItem> orderItemList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ArrayList<Top> tops = Facade.getTops();
        ArrayList<Bottom> bottoms =  Facade.getBottoms();

        request.getSession().setAttribute("tops", tops);
        request.getSession().setAttribute("bottoms", bottoms);
        request.getSession().setAttribute("orderItemList", orderItemList);

        request.getRequestDispatcher("WEB-INF/browse.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
