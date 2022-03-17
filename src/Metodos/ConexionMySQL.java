/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author fundacion
 */
public class ConexionMySQL {
    
    public static String user = "root";
    public static String pass = "";
    public static String url = "jdbc:mysql://localhost/bdcontactos";
   
    
    
    public static Connection Conectar() throws SQLException {
        
        Connection conexion = null;
        
        try{
            
            Class.forName("org.gjt.mm.mysql.Driver");
            
            conexion = (Connection) DriverManager.getConnection(url, user, pass);
            
        }catch(ClassNotFoundException | SQLException ex) {
            
            JOptionPane.showMessageDialog(null, ex);
            
        }
        
        return conexion;
    }
    
}
