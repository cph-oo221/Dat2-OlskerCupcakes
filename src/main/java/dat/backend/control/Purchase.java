package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.User;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.Facade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Purchase", value = "/Purchase")
public class Purchase extends HttpServlet
{
    ConnectionPool connectionPool = ApplicationStart.getConnectionPool();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        User user = (User) request.getAttribute("user");
        int idUser = user.getIdUser();
        int idReceipt = (int) request.getAttribute("idReceipt");
        int total = (int) request.getAttribute("total");

        Facade.purchase(idUser,idReceipt, total, connectionPool);

        request.getRequestDispatcher("WEB-INF/orders.jsp").forward(request,response);
    }
}
