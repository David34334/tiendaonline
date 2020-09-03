package controllerDAD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;
import services.Conexion;

public class UsuarioJDBC {
        private static UsuarioJDBC usuarioJDBC;
    
    private UsuarioJDBC(){
        
    }
    
    public static UsuarioJDBC instancia(){
        if(usuarioJDBC == null){
            usuarioJDBC = new UsuarioJDBC();
        }
        return usuarioJDBC;
    }
    
    private final String SQL_INSERT ="INSERT INTO usuario(nombre,apellido,correo,clave,direccion,identificacion,id_rol,id_carrito) values(?,?,?,?,?,?,?,?)";
    public String insertarUsuario(Usuario usuario){
        Connection conn=null;
        PreparedStatement stm=null;
        String mensaje="";
        int row=0;
        try{
            
            conn = Conexion.getConnection() ;
            stm = conn.prepareStatement(SQL_INSERT);
            stm.setString(1, usuario.getNombre());
            stm.setString(2, usuario.getApellido());
            stm.setString(3, usuario.getCorreo());
            stm.setString(4, usuario.getClave());
            stm.setString(5, usuario.getDireccion());
            stm.setString(6, usuario.getIdentificacion());
            stm.setInt(7,usuario.getId_rol());
            stm.setInt(8,usuario.getId_carrito());
            row = stm.executeUpdate();
            mensaje = "Se inserto " + row +" registro, satisfactoriamente.";
        }catch(SQLException e){
            mensaje = "Error: " + e.getMessage();
        }finally{
            Conexion.closed(conn);
            Conexion.closed(stm);
        }
        return mensaje;
    }
    
    
    private final String SQL_SELECT_CAT="SELECT nombre,apellido,correo,direccion,identificacion,id_rol FROM usuario WHERE id=?";
    public Usuario consultarUsuario(int id){
        Connection conn=null;
        PreparedStatement stm=null;
        ResultSet rs=null;
        Usuario usuario=null;
        try{
            conn = Conexion.getConnection() ;
            stm = conn.prepareStatement(SQL_SELECT_CAT);
            stm.setInt(1,id);
            rs = stm.executeQuery();
            while(rs.next()){
                usuario = new Usuario();
//                producto.setId(rs.getInt(1));
                usuario.setNombre(rs.getString(1));
                usuario.setApellido(rs.getString(2));
                usuario.setCorreo(rs.getString(3));
                usuario.setDireccion(rs.getString(4));
                usuario.setIdentificacion(rs.getString(5));
                usuario.setId_rol(Integer.parseInt(rs.getString(6)));
            }
        }catch(SQLException e){
            
        }finally{
            Conexion.closed(conn);
            Conexion.closed(stm);
            Conexion.closed(rs);
        }
        return usuario;
    }
    


    private final String SQL_INICIAR_SESION = "SELECT * FROM usuario WHERE correo=? and clave=?";
    public int autenticacion(String correo, String contrasena) {
        Connection conn=null;
        PreparedStatement stm=null;
        ResultSet rs=null;
        int id = -1;
        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_INICIAR_SESION);
            stm.setString(1, correo);
            stm.setString(2, contrasena);
            rs = stm.executeQuery();
            
            if(rs.absolute(1)) {
                id = Integer.parseInt(rs.getString(1));
                return id;
            }
            
        } catch (Exception e) {
        } finally {
            Conexion.closed(conn);
            Conexion.closed(stm);
            Conexion.closed(rs);
        }
        return id;
    }
    
    private final String SQL_UPDATE = "UPDATE usuario SET nombre=?, apellido=?, direccion=? WHERE id=?";
    public String actualizarEmpleo(Usuario user) {
        String mensaje = "";
        Connection conn = null;
        PreparedStatement stm = null;
        int row = 0;
        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stm.setString(index++, user.getNombre());
            stm.setString(index++, user.getApellido());
            stm.setString(index++, user.getDireccion());
            stm.setInt(index++, user.getId());
            row = stm.executeUpdate();
            mensaje = "Se actualizo" + row + "registro(s) satisfactoriamente";
        } catch (SQLException e) {
            mensaje = "Error: " + e.getMessage();
        } finally {

            Conexion.closed(conn);
            Conexion.closed(stm);
        }
        return mensaje;
    }


//    private final String SQL_SELECT="SELECT id,nombre,descripcion FROM producto ORDER BY id";
//    public String listarUsuario(){
//        Connection conn=null;
//        PreparedStatement stm=null;
//        ResultSet rs=null;
//        List<Producto> lista = new ArrayList();
//        Producto producto=null;
//        try{
//            
//            conn = Conexion.getConnection() ;
//            stm = conn.prepareStatement(SQL_SELECT);
//            rs = stm.executeQuery();
//            while(rs.next()){
//                producto = new Producto();
//                producto.setId(rs.getInt(1));
//                producto.setNombre(rs.getString(2));
//                producto.setDescripcion(rs.getString(3));
//                lista.add(producto);
//            }
//        }catch(SQLException e){
//            
//        }finally{
//            Conexion.closed(conn);
//            Conexion.closed(stm);
//            Conexion.closed(rs);
//        }
//        return lista;
//    }

    
}
