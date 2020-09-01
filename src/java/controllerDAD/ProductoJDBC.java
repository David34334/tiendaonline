package controllerDAD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Producto;
import services.Conexion;


public class ProductoJDBC {
    private static ProductoJDBC productoJDBC;
    
    private ProductoJDBC(){
        
    }
    
    public static ProductoJDBC instancia(){
        if(productoJDBC == null){
            productoJDBC = new ProductoJDBC();
        }
        return productoJDBC;
    }
    
    private final String SQL_INSERT ="INSERT INTO producto(nombre,precio,imagen,descripcion,id_categoria) values(?,?,?,?,?)";
    public String insertarProducto(Producto producto){
        Connection conn=null;
        PreparedStatement stm=null;
        String mensaje="";
        int row=0;
        try{
            
            conn = Conexion.getConnection() ;
            stm = conn.prepareStatement(SQL_INSERT);
            int index =1; 
            //stm.setInt(index++,producto.getId());
            stm.setString(index++, producto.getNombre());
            stm.setDouble(index++, producto.getPrecio());
            stm.setString(index++, producto.getImagen());
            stm.setString(index++, producto.getDescripcion());
            stm.setInt(index++, producto.getId_categoria());
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
    
    
    private final String SQL_SELECT_CAT="SELECT * FROM producto WHERE id=?";
    public Producto consultarProducto( int id){
        Connection conn=null;
        PreparedStatement stm=null;
        ResultSet rs=null;
        Producto producto=null;
        try{
            conn = Conexion.getConnection() ;
            stm = conn.prepareStatement(SQL_SELECT_CAT);
            stm.setInt(1,id);
            rs = stm.executeQuery();
            while(rs.next()){
                producto = new Producto();
                producto.setId(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setPrecio(rs.getDouble(3));
                producto.setImagen(rs.getString(4));
                producto.setDescripcion(rs.getString(5));
                producto.setId_categoria(rs.getInt(6));
            }
        }catch(SQLException e){
            
        }finally{
            Conexion.closed(conn);
            Conexion.closed(stm);
            Conexion.closed(rs);
        }
        return producto;
    }
    
    private final String SQL_UPDATE ="UPDATE producto SET nombre=?, descripcion=? WHERE id=?";
    public String modificarProducto(Producto producto){
        Connection conn=null;
        PreparedStatement stm=null;
        String mensaje="";
        int row=0;
        try{
            
            conn = Conexion.getConnection() ;
            stm = conn.prepareStatement(SQL_UPDATE);
            int index =1; 
            stm.setString(index++, producto.getNombre());
            stm.setString(index++, producto.getDescripcion());
            //stm.setInt(index++,producto.getId());
            row = stm.executeUpdate();
            mensaje = "Se actualizó " + row +" registro, satisfactoriamente.";
        }catch(SQLException e){
            mensaje = "Error: " + e.getMessage();
        }finally{
            Conexion.closed(conn);
            Conexion.closed(stm);
        }
        return mensaje;
    }
    
    private final String SQL_DELETE ="DELETE FROM producto WHERE id=?";
    public String borrarProducto(int idProducto){
        Connection conn=null;
        PreparedStatement stm=null;
        String mensaje="";
        int row=0;
        try{
            
            conn = Conexion.getConnection() ;
            stm = conn.prepareStatement(SQL_DELETE);
            int index =1; 
            stm.setInt(index++,idProducto);
            row = stm.executeUpdate();
            mensaje = "Se elimino " + row +" registro, satisfactoriamente.";
        }catch(SQLException e){
            mensaje = "Error: " + e.getMessage();
        }finally{
            Conexion.closed(conn);
            Conexion.closed(stm);
        }
        return mensaje;
    }
    
    private final String SQL_SELECT="SELECT * FROM producto ORDER BY id";
    public List<Producto> listarProductos(){
        Connection conn=null;
        PreparedStatement stm=null;
        ResultSet rs=null;
        List<Producto> lista = new ArrayList();
        Producto producto=null;
        try{
            
            conn = Conexion.getConnection() ;
            stm = conn.prepareStatement(SQL_SELECT);
            rs = stm.executeQuery();
            while(rs.next()){
                producto = new Producto();
                producto.setId(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setPrecio(Double.parseDouble(rs.getString(3)));
                producto.setImagen(rs.getString(4));
                producto.setDescripcion(rs.getString(5));
                producto.setId_categoria(rs.getInt(6));
                lista.add(producto);
            }
        }catch(SQLException e){
            
        }finally{
            Conexion.closed(conn);
            Conexion.closed(stm);
            Conexion.closed(rs);
        }
        return lista;
    }
    
}
