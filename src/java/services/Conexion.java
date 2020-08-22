package services;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Equipo440IS
 */
public class Conexion {
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver"; //"org.postgresql.Driver";  //"com.mysql.jdbc.Driver";
    private static String DB = "tienda";
    private static String JDBC_URL = "jdbc:mysql://localhost:3306/"+DB ;//"jdbc:postgresql://localhost:5432/"+ DB;  //"jdbc:mysql://localhost:3306/+DB;
    private static String JDBC_USER = "root";  //"root";
    private static String JDBC_PASS = ""; 
    private static Driver driver;
    
    public static synchronized Connection getConnection() throws SQLException{
        if(driver ==null){
            try{
               Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
               driver = (Driver)jdbcDriverClass.newInstance();
               DriverManager.registerDriver(driver);
            }catch(ClassNotFoundException  |  InstantiationException | 
                    IllegalAccessException e){
                System.out.println("Fallo en cargar el Driver");
            }
        }
        return DriverManager.getConnection(JDBC_URL,JDBC_USER, JDBC_PASS);
    }
    
    public static void closed(ResultSet rs){
        try{
            if(rs!=null)
                rs.close();
        }catch(SQLException e){
            
        }
    }
    
    public static void closed(PreparedStatement stmt){
        try{
            if(stmt!=null)
                stmt.close();
        }catch(SQLException e){
            
        }
    }
    
    public static void closed(Connection conn){
        try{
            if(conn!=null)
                conn.close();
        }catch(SQLException e){
            
        }
    }

    
}
