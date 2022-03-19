package DataBaseFunctions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConnectionMySQL {

    public static String dbServer = "mysql-72602-0.cloudclusters.net"; // change it to your database server name
    public static int dbPort = 12447; // change it to your database server port
    public static String dbName = "UsersLogin";
    public static String userName = "admin";
    public static String password = "Jye0g2UG";
    public static String url = "jdbc:mysql://" + dbServer + ":" + dbPort + "/" + dbName+"?characterEncoding=utf8";

    public static Connection Conectar() throws SQLException {

        Connection conexion = null;

        try{

            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = DriverManager.getConnection(url, userName, password);

        } catch(ClassNotFoundException | SQLException ex) {

            JOptionPane.showMessageDialog(null, ex);

        }
        return conexion;
    }

}
