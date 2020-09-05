package controller;

import controllerDAD.CarroJDBC;
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
import model.Carro;
import model.Orden;
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
            if (request.getParameter("accion").equals("Cerrar Sesion")) {
                cerrarSesion(request, response);
            }
            if (request.getParameter("accion").equals("Editar Datos")) {
                actualizarDatos(request, response);
            }
            if (request.getParameter("accion").equals("Mis Compras")) {
                compras(request, response);
            }
        } else {
            //Inicializar todos los usuarios y productos
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("accion").equals("Registrarse")) {
            registrar(request, response);
        }
        if (request.getParameter("accion").equals("Iniciar Sesion")) {
            iniciarSesion(request, response);
        }
        if (request.getParameter("accion").equals("Ya tienes una cuenta?")) {
            request.getRequestDispatcher("WEB-INF/serviciostienda/tiendaLogin.jsp").forward(request, response);
        }
        if (request.getParameter("accion").equals("No tienes una cuenta?")) {
            request.getRequestDispatcher("WEB-INF/serviciostienda/tiendaRegistro.jsp").forward(request, response);
        }
        if (request.getParameter("accion").equals("Editar")) {
            editarUsuario(request, response);
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
        user.setId_carrito(1);
        String mensaje = UsuarioJDBC.instancia().insertarUsuario(user);
        response.sendRedirect("ProductoCtrl");
    }

        


    public void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String correo = request.getParameter("correo");
        String clave = request.getParameter("clave");
        if (UsuarioJDBC.instancia().autenticacion(correo, clave) >= 0) {
            HttpSession objsesion = request.getSession(true);
            objsesion.setAttribute("usuario", correo);
            objsesion.setAttribute("id", UsuarioJDBC.instancia().autenticacion(correo, clave));
            Usuario user = null;
            user = UsuarioJDBC.instancia().consultarUsuario(UsuarioJDBC.instancia().autenticacion(correo, clave));
            if(user.getId_rol() == 0) {
                int rol = user.getId_rol();
                objsesion.setAttribute("rol", rol);
            }
            response.sendRedirect("ProductoCtrl");
        } else {
            request.getRequestDispatcher("WEB-INF/serviciostienda/tiendaLogin.jsp").forward(request, response);
        }
    }

    public void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect("ProductoCtrl");
    }

    public void actualizarDatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession objsesion = request.getSession(false);
        String usuario = (String) objsesion.getAttribute("usuario");
        int id = (int) objsesion.getAttribute("id");
        Usuario user = new Usuario();
        user = UsuarioJDBC.instancia().consultarUsuario(id);
        request.setAttribute("usuario", user);
        request.setAttribute("id", id);
        request.getRequestDispatcher("WEB-INF/usuarios/editarDatos.jsp").forward(request, response);
    }
    
    public void compras(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession objsesion = request.getSession(false);
        String usuario = (String) objsesion.getAttribute("usuario");
        int id = (int) objsesion.getAttribute("id");
        Usuario user = new Usuario();
        user = UsuarioJDBC.instancia().consultarUsuario(id);
        request.setAttribute("usuario", user);
        request.setAttribute("id", id);
        List<Carro> carros = new ArrayList();
        carros = CarroJDBC.instancia().listarCarros(id);
        request.setAttribute("carros", carros);
        request.getRequestDispatcher("WEB-INF/usuarios/compras.jsp").forward(request, response);
    }

    private void editarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Usuario user = new Usuario();
        user.setId(Integer.parseInt(request.getParameter("id")));
        user.setNombre(request.getParameter("nombre"));
        user.setApellido(request.getParameter("apellido"));
        user.setDireccion(request.getParameter("direccion"));
        String mensaje = UsuarioJDBC.instancia().actualizarEmpleo(user);
        response.sendRedirect("ProductoCtrl");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
