package dat.backend.control;

import dat.backend.model.persistence.Facade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditUser", value = "/EditUser")
public class EditUser extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String balance = request.getParameter("balance");

        
        request.getRequestDispatcher("WEB-INF/adminEdit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String email = request.getParameter("Email");
        String balance = request.getParameter("Balance");

        request.setAttribute("editUser", email);
        request.setAttribute("balance", balance);

        request.getRequestDispatcher("WEB-INF/adminEdit.jsp").forward(request, response);
    }
}
