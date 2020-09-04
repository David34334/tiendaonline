package controller;

import controllerDAD.OrdenJDBC;
import controllerDAD.ProductoJDBC;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Orden;
import model.Producto;

@WebServlet(name = "CarroCtrl", urlPatterns = {"/CarroCtrl"})
public class CarroCtrl extends HttpServlet {

    List<Orden> ordenes = new ArrayList();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("accion") != null) {

        } else {
            
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("accion").equals("Confirmar")) {
            agregarCarro(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void agregarCarro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_producto = Integer.parseInt(request.getParameter("idProducto"));
        Orden orden = new Orden();
        orden.setId_carro(Integer.parseInt(request.getParameter("idUsuario")));
        orden.setCantidad(1);
        orden.setId_producto(id_producto);
        orden.setPrecio(Double.parseDouble(request.getParameter("precioproducto")));
        String mensaje = OrdenJDBC.instancia().insertarOrden(orden);
        
        //ENVIO DE DATOS NECESARIOS A PAGARPRODUCTO
        Producto product = ProductoJDBC.instancia().consultarProducto(id_producto);
        request.setAttribute("producto", product);
        request.setAttribute("idUsuario", request.getParameter("idUsuario"));
        request.setAttribute("cantidad", orden.getCantidad());
        request.getRequestDispatcher("WEB-INF/carro/pagarProducto.jsp").forward(request, response);
        ordenes.add(orden);
    }

    private void mostrarCarro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
