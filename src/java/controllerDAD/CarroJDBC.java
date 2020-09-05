/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerDAD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Carro;
import model.Producto;
import services.Conexion;

/**
 *
 * @author b_urb
 */
public class CarroJDBC {
        private static CarroJDBC carroJDBC;
    
    private CarroJDBC(){
        
    }
    
    public static CarroJDBC instancia(){
        if(carroJDBC == null){
            carroJDBC = new CarroJDBC();
        }
        return carroJDBC;
    }
    
    private final String SQL_INSERT ="INSERT INTO carrito(precio,id_usuario,estado) values(?,?,?)";
    public String insertarCarro(Carro carro){
        Connection conn=null;
        PreparedStatement stm=null;
        String mensaje="";
        int row=0;
        try{
            
            conn = Conexion.getConnection() ;
            stm = conn.prepareStatement(SQL_INSERT);
            int index =1;
            stm.setDouble(index++, carro.getPrecio());
            stm.setInt(index++, carro.getId_usuario());
            stm.setString(index++, carro.getEstado());
//            stm.setInt(index++, carro.getReferencia());
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
    
    
    private final String SQL_SELECT_CAT="SELECT * FROM carrito WHERE id=?";
    public Carro consultarCarro(int id){
        Connection conn=null;
        PreparedStatement stm=null;
        ResultSet rs=null;
        Carro carro=null;
        try{
            conn = Conexion.getConnection() ;
            stm = conn.prepareStatement(SQL_SELECT_CAT);
            stm.setInt(1,id);
            rs = stm.executeQuery();
            while(rs.next()){
                carro = new Carro();
                carro.setId(rs.getInt(1));
                carro.setPrecio(rs.getDouble(2));
                carro.setId_usuario(rs.getInt(3));
                carro.setEstado(rs.getString(4));
                carro.setReferencia(rs.getInt(5));
            
            }
        }catch(SQLException e){
            
        }finally{
            Conexion.closed(conn);
            Conexion.closed(stm);
            Conexion.closed(rs);
        }
        return carro;
    }
    
    private final String SQL_COUNT_CAT="SELECT COUNT(*) FROM carrito";
    public int cantidadRegistros(){
        Connection conn=null;
        PreparedStatement stm=null;
        ResultSet rs=null;
        int total=0;
        try{
            conn = Conexion.getConnection() ;
            stm = conn.prepareStatement(SQL_COUNT_CAT);
            rs = stm.executeQuery();
            total = rs.getInt(1);
        }catch(SQLException e){
            
        }finally{
            Conexion.closed(conn);
            Conexion.closed(stm);
            Conexion.closed(rs);
        }
        return total;
    }
     private final String SQL_SELECT="SELECT id,precio,estado FROM carrito WHERE id_usuario=?";
    public List<Carro> listarCarros(int id){
        Connection conn=null;
        PreparedStatement stm=null;
        ResultSet rs=null;
        List<Carro> lista = new ArrayList();
        Carro carro=null;
        try{
            
            conn = Conexion.getConnection() ;
            stm = conn.prepareStatement(SQL_SELECT);
            stm.setInt(1,id);
            rs = stm.executeQuery();
            while(rs.next()){
                carro = new Carro();
                carro.setId(rs.getInt(1));
                carro.setPrecio(Double.parseDouble(rs.getString(2)));
                carro.setEstado(rs.getString(3));
                lista.add(carro);
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
