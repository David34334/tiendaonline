package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductoCtrl", urlPatterns = {"/ProductoCtrl"})
public class ProductoCtrl extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("accion").equals("Comprar")) {
            request.getRequestDispatcher("WEB-INF/serviciostienda/tiendaLogin.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("accion").equals("LogIn")) {
            request.getRequestDispatcher("WEB-INF/serviciostienda/tiendaLogin.jsp").forward(request, response);
        }
        if(request.getParameter("accion").equals("SignIn")) {
            request.getRequestDispatcher("WEB-INF/serviciostienda/tiendaRegistro.jsp").forward(request, response);
        }
    }
}
