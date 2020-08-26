/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
                productos = cargarProductos();
                request.setAttribute("productos", productos);
                request.getRequestDispatcher("WEB-INF/serviciostienda/tiendaIndex.jsp").forward(request, response);
            }
        } else {
            productos = cargarProductos();
            request.setAttribute("productos", productos);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("accion").equals("LogIn")) {
            request.getRequestDispatcher("WEB-INF/serviciostienda/tiendaLogin.jsp").forward(request, response);
        }
        if (request.getParameter("accion").equals("SignIn")) {
            request.getRequestDispatcher("WEB-INF/serviciostienda/tiendaRegistro.jsp").forward(request, response);
        }
    }

    public List<Producto> cargarProductos() {
        List<Producto> listaProductos = new ArrayList();

        Producto p1 = new Producto(0, "Poratil Lenovo", 1750000, "img/lenovo.png", "16GB RAM, 1TB");
        Producto p2 = new Producto(0, "Poratil Asus", 3750000, "img/asus.jpg", "16GB RAM, 1TB");
        Producto p3 = new Producto(0, "Poratil Dell", 1250000, "img/dell.jpg", "8GB RAM, 1TB");
        Producto p4 = new Producto(0, "Poratil HP", 1399000, "img/hp.jpg", "16GB RAM, 1TB");
        Producto p5 = new Producto(0, "PC - Escritorio", 2750000, "img/pc.jpg", "16GB RAM, 1TB");
        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);
        listaProductos.add(p4);
        listaProductos.add(p5);

        return listaProductos;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
