package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Receipt;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.Facade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Receipts", value = "/Receipts")
public class Receipts extends HttpServlet
{
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ArrayList<Receipt> receipts = null;
        try
        {
            receipts = (ArrayList<Receipt>) Facade.getAllReceipts(connectionPool);
        }
        catch (DatabaseException e)
        {
            e.printStackTrace();
        }

        request.setAttribute("receipts", receipts);

        request.getRequestDispatcher("WEB-INF/receipts.jsp").forward(request, response);
    }
}
