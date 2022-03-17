/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Show;
import Metodos.ConexionMySQL;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author fundacion
 */
public final class Show {
     public Show() throws SQLException {
         
     }
     public String[][] cargar() throws SQLException {
        
         
         String sql = "SELECT *FROM contacto";
 
         Connection conect;
         int count = 0;
         
         try {
             
             conect = ConexionMySQL.Conectar();
             Statement st = (Statement) conect.createStatement();
             ResultSet rs = st.executeQuery(sql);
             
             while (rs.next()){
           
             count = count +1;
           
             
             
         }
         conect.close();
            
         }catch(SQLException e) {
             
                 JOptionPane.showMessageDialog(null, e);
                    
                 }
         
         String[][] result = new String[count][7];
         
         int aux = 0;
         try {
             conect = ConexionMySQL.Conectar();
             Statement st = (Statement) conect.createStatement();
             ResultSet rs = st.executeQuery(sql);
            
             
             
             while (rs.next()) {
              result[aux][0] = rs.getString("nombres");
    
             result[aux][1] = rs.getString("apellidos");
                
             result[aux][2] = rs.getString("email");
             
             result[aux][3] = rs.getString("celular");
             
             result[aux][4] = rs.getString("sexo");
             
             result[aux][5] = rs.getString("username");
             
             result[aux][6] = rs.getString("password");
             aux = aux +1;
             
                 
             }

             conect.close();
             
             
         } catch(SQLException e) {
             
             JOptionPane.showMessageDialog(null, e);
             
         }
         
         return result;
    
     }
}
