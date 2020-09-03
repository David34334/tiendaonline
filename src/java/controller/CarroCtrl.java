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


@WebServlet(name = "CarroCtrl", urlPatterns = {"/CarroCtrl"})
public class CarroCtrl extends HttpServlet {
    List<Orden> ordenes = new ArrayList();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("accion") != null) {
            if(request.getParameter("accion").equals("Confirmar")) {
                agregarCarro(request, response);
            }
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

    
    private void agregarCarro(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        int id_producto = Integer.parseInt(request.getParameter("id"));
        Orden orden = new Orden();
        orden.setCantidad(1);
        orden.setId_producto(id_producto);
        String mensaje = OrdenJDBC.instancia().insertarOrden(orden);
        ordenes.add(orden);
    }
}
