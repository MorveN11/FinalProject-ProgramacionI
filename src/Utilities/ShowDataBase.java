/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;
import DataBaseFunctions.ConnectionMySQL;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author fundacion
 */
public final class ShowDataBase {
     public ShowDataBase() throws SQLException {
         
     }
     public String[][] showData() throws SQLException {
        
         
         String sql = "SELECT *FROM data";
 
         Connection connection;
         int fCount = 0;
         
         try {
             
             connection = ConnectionMySQL.Conectar();
             Statement st = (Statement) connection.createStatement();
             ResultSet rs = st.executeQuery(sql);
             
             while (rs.next()){
           
             fCount += 1;
             
         }
         connection.close();
            
         }catch(SQLException e) {
             
                 JOptionPane.showMessageDialog(null, e);
                    
                 }
         
         String[][] result = new String[fCount][7];
         
         int aux = 0;
         try {
             connection = ConnectionMySQL.Conectar();
             Statement st = (Statement) connection.createStatement();
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

             connection.close();
             
             
         } catch(SQLException e) {
             
             JOptionPane.showMessageDialog(null, e);
             
         }
         
         return result;
    
     }
}
