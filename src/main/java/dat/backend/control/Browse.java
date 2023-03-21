package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.Top;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.Facade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Browse", value = "/browse")
public class Browse extends HttpServlet
{
    ConnectionPool connectionPool = ApplicationStart.getConnectionPool();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Top> tops = null;
        ArrayList<Bottom> bottoms = null;
        try {
            tops = Facade.getTops(connectionPool);
            bottoms =  Facade.getBottoms(connectionPool);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        request.getSession().setAttribute("tops", tops);
        request.getSession().setAttribute("bottoms", bottoms);

        request.getRequestDispatcher("WEB-INF/browse.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
