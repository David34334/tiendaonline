package controller;

import controllerDAD.CarroJDBC;
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
import model.Carro;
import model.Orden;

import model.Usuario;


import model.Producto;


@WebServlet(name = "CarroCtrl", urlPatterns = {"/CarroCtrl"})
public class CarroCtrl extends HttpServlet {

    List<Orden> ordenes = new ArrayList();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if(request.getParameter("accion") != null) {
            if(request.getParameter("accion").equals("Anadir")) {
                agregarCarro(request, response);
            }
            
//            if(request.getParameter("accion").equals("Confirmar")) {
//                agregarCarro(request, response);
//            }
 else {
            
        }
    }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("accion").equals("Anadir")) {
            agregarCarro(request, response);
        }
        if(request.getParameter("accion").equals("Pagar")) {
                comprarCarro(request, response);
            }
         if(request.getParameter("accion").equals("Volver")) {
                request.getRequestDispatcher("WEB-INF/serviciostienda/tiendaIndex.jsp").forward(request, response);
            }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


    private void agregarCarro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_producto = Integer.parseInt(request.getParameter("idProducto"));
        Orden orden = new Orden();
//        orden.setId_carro(Integer.parseInt(request.getParameter("idUsuario")));
        orden.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
        orden.setId_producto(id_producto);
        orden.setPrecio(Double.parseDouble(request.getParameter("precioproducto")));
        int id_carro = OrdenJDBC.instancia().insertarOrden(orden);
//        Carro carro = new Carro();
//        carro.setId_usuario(Integer.parseInt(request.getParameter("idUsuario")));
//        carro.setEstado("proceso");
//        carro.setPrecio(0);
//        int mensaje2 = CarroJDBC.instancia().insertarCarro(carro);
        //ENVIO DE DATOS NECESARIOS A PAGARPRODUCTO
        ordenes = OrdenJDBC.instancia().listarOrdenes(id_carro);
        List<Producto> productos = new ArrayList();
        for (Orden ordene : ordenes) {
            Producto product = ProductoJDBC.instancia().consultarProducto(ordene.getId_producto());
            product.setCantidad(ordene.getCantidad());
            productos.add(product);
        }
        request.setAttribute("productos", productos);
//        request.setAttribute("idUsuario", request.getParameter("idUsuario"));
        request.setAttribute("total", calcularPrecio());
        Usuario user = (Usuario) request.getAttribute("user");
        request.setAttribute("user", user);
        
//        request.setAttribute("ordenes", ordenes);
        request.getRequestDispatcher("WEB-INF/carro/pagarProducto.jsp").forward(request, response);
        

    }
    
    private double calcularPrecio(){
        double total =0;
        
        for (Orden ordene : ordenes) {
            total = total+ ordene.getCantidad()*ordene.getPrecio();
        }
        return total;
    
    }

    private void comprarCarro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Carro carro = new Carro();
        carro.setEstado("pagado");
        carro.setId_usuario(Integer.parseInt(request.getParameter("idUsuario")));
        carro.setPrecio(Integer.parseInt(request.getParameter("total")));
        String msg = CarroJDBC.instancia().insertarCarro(carro);

    }
}
