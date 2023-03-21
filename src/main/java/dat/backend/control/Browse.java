package dat.backend.control;

import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.Top;
import dat.backend.model.persistence.Facade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Browse", value = "/browse")
public class Browse extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ArrayList<Top> tops = Facade.getTops();
        ArrayList<Bottom> bottoms =  Facade.getBottoms();

        request.getSession().setAttribute("tops", tops);
        request.getSession().setAttribute("bottoms", bottoms);

        request.getRequestDispatcher("WEB-INF/browse.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
