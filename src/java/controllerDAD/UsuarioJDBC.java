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
    
    private final String SQL_INSERT ="INSERT INTO usuario(nombre,apellido,correo,clave,direccion,identificacion,id_rol) values(?,?,?,?,?,?,?)";
    public String insertarUsuario(Usuario usuario){
        Connection conn=null;
        PreparedStatement stm=null;
        String mensaje="";
        int row=0;
        try{
            
            conn = Conexion.getConnection() ;
            stm = conn.prepareStatement(SQL_INSERT);
            int index =1;
            stm.setString(index++, usuario.getNombre());
            stm.setString(index++, usuario.getApellido());
            stm.setString(index++, usuario.getCorreo());
            stm.setString(index++, usuario.getClave());
            stm.setString(index++, usuario.getDireccion());
            stm.setString(index++, usuario.getIdentificacion());
            stm.setInt(index++,usuario.getId_rol());
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
    
    
    private final String SQL_SELECT_CAT="SELECT nombre,apellido,direccion,identificacion FROM usuario WHERE id=?";
    public Usuario consultarUsuario( int id){
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
                usuario.setDireccion(rs.getString(3));
                usuario.setIdentificacion(rs.getString(4));
            
            }
        }catch(SQLException e){
            
        }finally{
            Conexion.closed(conn);
            Conexion.closed(stm);
            Conexion.closed(rs);
        }
        return usuario;
    }
    
//    private final String SQL_UPDATE ="UPDATE producto SET nombre=?, descripcion=? WHERE id=?";
//    public String modificarUsuario(Usuario usuario){
//        Connection conn=null;
//        PreparedStatement stm=null;
//        String mensaje="";
//        int row=0;
//        try{
//            
//            conn = Conexion.getConnection() ;
//            stm = conn.prepareStatement(SQL_UPDATE);
//            int index =1; 
//            stm.setString(index++, producto.getNombre());
//            stm.setString(index++, producto.getDescripcion());
//            stm.setInt(index++,producto.getId());
//            row = stm.executeUpdate();
//            mensaje = "Se actualizó " + row +" registro, satisfactoriamente.";
//        }catch(SQLException e){
//            mensaje = "Error: " + e.getMessage();
//        }finally{
//            Conexion.closed(conn);
//            Conexion.closed(stm);
//        }
//        return mensaje;
//    }
//    
//    private final String SQL_DELETE ="DELETE FROM producto WHERE id=?";
//    public String borrarProducto(int idProducto){
//        Connection conn=null;
//        PreparedStatement stm=null;
//        String mensaje="";
//        int row=0;
//        try{
//            
//            conn = Conexion.getConnection() ;
//            stm = conn.prepareStatement(SQL_DELETE);
//            int index =1; 
//            stm.setInt(index++,idProducto);
//            row = stm.executeUpdate();
//            mensaje = "Se elimino " + row +" registro, satisfactoriamente.";
//        }catch(SQLException e){
//            mensaje = "Error: " + e.getMessage();
//        }finally{
//            Conexion.closed(conn);
//            Conexion.closed(stm);
//        }
//        return mensaje;
//    }
//    
//    private final String SQL_SELECT="SELECT id,nombre,descripcion FROM producto ORDER BY id";
//    public List<Producto> listarProductos(){
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
