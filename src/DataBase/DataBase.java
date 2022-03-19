package DataBase;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class DataBase {

    public static String Names;
    public static String LastNames;
    public static String Email;
    public static String CellPhone;
    public static String Gender;
    public static String[][] table;


    public static void searchUsers() {

        String sql = "SELECT *FROM Data";
        Connection connection;
        int fCount = 0;

        try {

             connection = SQL.Connect();
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

             connection = SQL.Connect();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql);

             while (rs.next()) {

                 table[fCount][0] = rs.getString("Names");
                 table[fCount][1] = rs.getString("LastNames");
                 table[fCount][2] = rs.getString("Email");
                 table[fCount][3] = rs.getString("CellPhone");
                 table[fCount][4] = rs.getString("Gender");
                 table[fCount][5] = rs.getString("UserName");
                 table[fCount][6] = rs.getString("Password");
                 fCount += 1;

             }

             connection.close();

         } catch(SQLException e) {

             JOptionPane.showMessageDialog(null, e);

         }
     }

     public static void showUsers() {

         searchUsers();

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
