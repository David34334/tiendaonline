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
import model.Orden;
import services.Conexion;

/**
 *
 * @author b_urb
 */
public class OrdenJDBC {
        private static OrdenJDBC ordenJDBC;
    
    private OrdenJDBC(){
        
    }
    
    public static OrdenJDBC instancia(){
        if(ordenJDBC == null){
            ordenJDBC = new OrdenJDBC();
        }
        return ordenJDBC;
    }
    
    private final String SQL_INSERT ="INSERT INTO orden(id_carro,id_producto,cantidad,precio) values(?,?,?,?)";
    public String insertarOrden(Orden orden){
        Connection conn=null;
        PreparedStatement stm=null;
        String mensaje="";
        int row=0;
        try{
            
            conn = Conexion.getConnection() ;
            stm = conn.prepareStatement(SQL_INSERT);
            int index =1;
            stm.setInt(index++, CarroJDBC.instancia().cantidadRegistros());
            stm.setInt(index++, orden.getId_producto());
            stm.setInt(index++, orden.getCantidad());
            stm.setDouble(index++, orden.getPrecio());
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
    
    
    private final String SQL_SELECT_CAT="SELECT * FROM orden WHERE id_carro=?";
    public Orden consultarOrden(int id){
        Connection conn=null;
        PreparedStatement stm=null;
        ResultSet rs=null;
        Orden orden=null;
        try{
            conn = Conexion.getConnection() ;
            stm = conn.prepareStatement(SQL_SELECT_CAT);
            stm.setInt(1,id);
            rs = stm.executeQuery();
            while(rs.next()){
                orden = new Orden();
                orden.setId_carro(rs.getInt(1));
                orden.setId_producto(rs.getInt(2));
                orden.setCantidad(rs.getInt(3));
            }
        }catch(SQLException e){
            
        }finally{
            Conexion.closed(conn);
            Conexion.closed(stm);
            Conexion.closed(rs);
        }
        return orden;
    }
    


    
    
    
}
