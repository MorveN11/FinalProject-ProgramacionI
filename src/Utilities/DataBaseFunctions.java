package Utilities;


import DataBaseFunctions.ConnectionMySQL;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public final class DataBaseFunctions {

     public static String[][] table;

     public static void save() {

         String sql = "SELECT *FROM data";
         Connection connection;
         int fCount = 0;
         
         try {

             connection = ConnectionMySQL.Conectar();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql);
             while (rs.next()){
             fCount += 1;

         }

         connection.close();

         } catch(SQLException e) {

             JOptionPane.showMessageDialog(null, e);

                 }
         
         table = new String[fCount][7];
         fCount = 0;

         try {

             connection = ConnectionMySQL.Conectar();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql);

             while (rs.next()) {

                 table[fCount][0] = rs.getString("nombres");
                 table[fCount][1] = rs.getString("apellidos");
                 table[fCount][2] = rs.getString("email");
                 table[fCount][3] = rs.getString("celular");
                 table[fCount][4] = rs.getString("sexo");
                 table[fCount][5] = rs.getString("username");
                 table[fCount][6] = rs.getString("password");
                 fCount += 1;

             }

             connection.close();

         } catch(SQLException e) {

             JOptionPane.showMessageDialog(null, e);

         }
     }

     public static void show() {

         save();

         for (String[] line : table) {

             System.out.print("[");

             for (int i = 0; i < line.length; i++) {

                 System.out.print(line[i]);

                 if (i != line.length - 1) {

                     System.out.print(", ");
                 }
             }
             System.out.println("]");
         }
     }
}
