package controller;

import controllerDAD.OrdenJDBC;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Orden;
import model.Usuario;


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
        } else {
            int id = (int) Integer.parseInt((String) request.getAttribute("id"));
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

   private void agregarCarro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idProducto = (int)request.getAttribute("id_producto");
        Usuario user = (Usuario) request.getAttribute("user");
        Orden orden = new Orden();
        orden.setId_producto(idProducto);
        orden.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
        orden.setPrecio(Integer.parseInt(request.getParameter("precio")));
        request.setAttribute("orden", orden);
        request.setAttribute("user", user);
        String msg = OrdenJDBC.instancia().insertarOrden(orden);
        request.getRequestDispatcher("WEB-INF/carro/carroIndex.jsp").forward(request, response);
    }
    
    private void mostrarCarro(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    
    
    }
}
