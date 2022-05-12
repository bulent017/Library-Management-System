/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Screen;

/**
 *
 * @author bulentoral
 */
import java.sql.*;

public class DBConnection {
  
    static Connection c =  null;
    public static Connection getConnection() throws SQLException {
        
        try{
            
           c = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms_u","root","1234");
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return c;
    }
    
}
