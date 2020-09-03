/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controllerDAD.ProductoJDBC;
import controllerDAD.UsuarioJDBC;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Producto;
import model.Usuario;

@WebServlet(name = "ProductoCtrl", urlPatterns = {"/ProductoCtrl"})
public class ProductoCtrl extends HttpServlet {

    List<Producto> productos = new ArrayList();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
        if (request.getParameter("accion") != null) {
            if (request.getParameter("accion").equals("Comprar")) {
                HttpSession objsesion = request.getSession(false);  
                int idUsuario = (int) objsesion.getAttribute("id");
                Usuario user = null;
                user = UsuarioJDBC.instancia().consultarUsuario(idUsuario);
                request.setAttribute("user", user);
                comprarArticulo(request, response);
            }
            if (request.getParameter("accion").equals("VerCatalogo")) {
                productos = ProductoJDBC.instancia().listarProductos();
                request.setAttribute("productos", productos);
                request.getRequestDispatcher("WEB-INF/serviciostienda/tiendaIndex.jsp").forward(request, response);
            }
            if (request.getParameter("accion").equals("Editar")) {
                editarProducto(request, response);
            }
            if (request.getParameter("accion").equals("Eliminar")) {
                eliminarProducto(request, response);
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
        if (request.getParameter("accion").equals("Editar")) {
            cambiarProducto(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void agregarCarro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_producto = Integer.parseInt(request.getParameter("id"));
        System.out.println("" + id_producto);
//        Producto producto = new Producto();

//        HttpSession objsesion = request.getSession(false);
//        String usuario = (String) objsesion.getAttribute("usuario");
//        if(usuario != null) {
//           request.getRequestDispatcher("WEB-INF/serviciostienda/tiendaCompra.jsp").forward(request, response); 
//        }
//        request.getRequestDispatcher("WEB-INF/serviciostienda/tiendaLogin.jsp").forward(request, response);
    }

    private void editarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Producto producto = null;
        producto = ProductoJDBC.instancia().consultarProducto(id);
        request.setAttribute("producto", producto);
        request.getRequestDispatcher("WEB-INF/serviciosadministrador/tiendaEditarProducto.jsp").forward(request, response);
    }

    private void cambiarProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Producto producto = new Producto();
        producto.setId(Integer.parseInt(request.getParameter("id")));
        producto.setNombre(request.getParameter("nombre"));
        producto.setDescripcion(request.getParameter("descripcion"));
        producto.setPrecio(Double.parseDouble(request.getParameter("precio")));
        String mensaje = ProductoJDBC.instancia().modificarProducto(producto);
        response.sendRedirect("ProductoCtrl");
    }

    private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String mensaje = ProductoJDBC.instancia().borrarProducto(id);
        response.sendRedirect("ProductoCtrl");
    }

    private void comprarArticulo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idProducto = Integer.parseInt(request.getParameter("id"));
        Usuario user = (Usuario) request.getAttribute("user");
        Producto product = ProductoJDBC.instancia().consultarProducto(idProducto);
        request.setAttribute("producto", product);
        request.setAttribute("user", user);
        request.getRequestDispatcher("WEB-INF/carro/carroIndex.jsp").forward(request, response);
//                agregarCarro(request, response);
    }

}
