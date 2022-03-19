package DataBaseFunctions;
        
        
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;


public class Verifiers {
    
    public static PreparedStatement preparedString;
    public static ResultSet result;
   
    public int Guardar(String txtNombrescontacto, String txtApellidoscontacto, String txtEmail, String txtCelular,
                       String cboxSexo, String txtUsername, String txtPassword){

        int resultado = 0;

        Connection con = null;

        String SSQL = "INSERT INTO Data (Names, LastNames, Email, CellPhone, Gender, UserName, Password) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            con = ConnectionMySQL.Conectar();
            try (PreparedStatement psql = con.prepareStatement(SSQL)) {

                psql.setString(1, txtNombrescontacto);
                psql.setString(2, txtApellidoscontacto);
                psql.setString(3, txtEmail);
                psql.setString(4, txtCelular);
                psql.setString(5, cboxSexo);
                psql.setString(6, txtUsername);
                psql.setString(7, txtPassword);
                resultado = psql.executeUpdate();

            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al intentar almacenar la información:\n"
                    + e, "Error en la operación", JOptionPane.ERROR_MESSAGE);

        } finally{

            try {

                if(con!=null){
                    con.close();
                }

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión:\n"
                        + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE);
            }
        }

        return resultado;
    }

    public static String SearchUser(String username) {

        String searchUser = null;
        Connection conexion;
    
        try {

            conexion = ConnectionMySQL.Conectar();
            String searchNames = ("SELECT Names, LastNames FROM Data WHERE UserName = '" + username + "'");
            preparedString = conexion.prepareStatement(searchNames);
            result = preparedString.executeQuery();

            if (result.next()){

                String name = result.getString("Names");
                String lastName = result.getString("LastNames");
                searchUser = (name +" "+ lastName);
            }

            conexion.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        }
        return searchUser;
    }

    public static String searchRegistUser (String username, String password) {

        String searchUser = null;
        Connection conexion;

        try {

            conexion = ConnectionMySQL.Conectar();
        
            String searchUserString = ("SELECT Names, UserName, Password FROM Data "
                    + "WHERE UserName = '"+username+"'  && Password = '"+ password +"'");

            preparedString = conexion.prepareStatement(searchUserString);
            result = preparedString.executeQuery();

            if (result.next()) {

                searchUser = "usuario encontrado";

            } else {

                searchUser = "usuario no encontardo";

            }

            conexion.close();

        }catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        }

        return searchUser;
    }
    
}
      

