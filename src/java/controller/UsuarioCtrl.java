package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;


@WebServlet(name = "UsuarioCtrl", urlPatterns = {"/UsuarioCtrl"})
public class UsuarioCtrl extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("accion") != null) {
            
        } else {
            //Inicializar todos los usuarios y productos
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("accion").equals("Registrar")) {
            registrar(request);
        }
    }
    
    public void registrar(HttpServletRequest request) {
        Usuario user = new Usuario();
        user.setNombre(request.getParameter("nombre"));
        user.setApellido(request.getParameter("apellido"));
        user.setCorreo(request.getParameter("correo"));
        user.setClave(request.getParameter("clave"));
        user.setIdentificacion(request.getParameter("cedula"));
        user.setDireccion(request.getParameter("direccion"));
    }
    
    public void iniciarSesion() {
        
    }
    
    public void cerrarSesion() {
        
    }
    
    public void actualizarDatos() {
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
