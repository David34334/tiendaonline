package controller;

import controllerDAD.UsuarioJDBC;
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
            if (request.getParameter("accion").equals("Registarse")) {
                request.getRequestDispatcher("WEB-INF/serviciostienda/tiendaRegistro.jsp").forward(request, response);
            }
            if (request.getParameter("accion").equals("Iniciar Sesion")) {
                request.getRequestDispatcher("WEB-INF/serviciostienda/tiendaLogin.jsp").forward(request, response);
            }
        } else {
            //Inicializar todos los usuarios y productos
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("accion").equals("Registrar")) {
            registrar(request, response);
        }
    }
    
    public void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Usuario user = new Usuario();
        user.setNombre(request.getParameter("nombre"));
        user.setApellido(request.getParameter("apellido"));
        user.setCorreo(request.getParameter("correo"));
        user.setClave(request.getParameter("clave"));
        user.setIdentificacion(request.getParameter("cedula"));
        user.setDireccion(request.getParameter("direccion"));
        user.setId_rol(1);
        String mensaje = UsuarioJDBC.instancia().insertarUsuario(user);
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
