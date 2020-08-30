/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controllerDAD.ProductoJDBC;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Producto;

@WebServlet(name = "ProductoCtrl", urlPatterns = {"/ProductoCtrl"})
public class ProductoCtrl extends HttpServlet {

    List<Producto> productos = new ArrayList();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("accion") != null) {
            if (request.getParameter("accion").equals("Comprar")) {
                request.getRequestDispatcher("WEB-INF/serviciostienda/tiendaLogin.jsp").forward(request, response);
            }
            if (request.getParameter("accion").equals("VerCatalogo")) {
                productos = ProductoJDBC.instancia().listarProductos();
                request.setAttribute("productos", productos);
                request.getRequestDispatcher("WEB-INF/serviciostienda/tiendaIndex.jsp").forward(request, response);
            }
        } else {
            productos = ProductoJDBC.instancia().listarProductos();
            request.setAttribute("productos", productos);
            request.getRequestDispatcher("WEB-INF/serviciostienda/tiendaIndex.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
