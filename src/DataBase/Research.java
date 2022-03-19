package DataBase;
        
        
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;


public class Research {

    public static int saveData(String txtNames, String txtLastNames, String txtEmail, String txtCellPhone,
                        String txtGender, String txtUsername, String txtPassword) {

        int resultSaveData = 0;

        Connection connection = null;

        String usersData = "INSERT INTO Data (Names, LastNames, Email, CellPhone, Gender, UserName, Password) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {

            connection = SQL.Connect();

            try (PreparedStatement searchUsersData = connection.prepareStatement(usersData)) {

                searchUsersData.setString(1, txtNames);
                searchUsersData.setString(2, txtLastNames);
                searchUsersData.setString(3, txtEmail);
                searchUsersData.setString(4, txtCellPhone);
                searchUsersData.setString(5, txtGender);
                searchUsersData.setString(6, txtUsername);
                searchUsersData.setString(7, txtPassword);
                resultSaveData = searchUsersData.executeUpdate();

            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al intentar almacenar la información:\n"
                    + e, "Error en la operación", JOptionPane.ERROR_MESSAGE);

        } finally{

            try {

                if(connection!=null){
                    connection.close();
                }

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión:\n"
                        + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE);
            }
        }

        return resultSaveData;
    }

    public static String SearchUser(String userName) {

        String searchUser = null;
        Connection connection;
    
        try {

            connection = SQL.Connect();
            String usersData = ("SELECT Names, LastNames FROM Data WHERE UserName = '" + userName + "'");
            PreparedStatement searchUserName = connection.prepareStatement(usersData);
            ResultSet resultSearch = searchUserName.executeQuery();

            if (resultSearch.next()){

                String names = resultSearch.getString("Names");
                String lastNames = resultSearch.getString("LastNames");
                searchUser = (names +" "+ lastNames);
            }

            connection.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        }
        return searchUser;
    }

    public static String searchRegisteredUser(String username, String password) {

        String resultSearch = null;
        Connection connection;

        try {

            connection = SQL.Connect();
        
            String usersData = ("SELECT Names, UserName, Password FROM Data "
                    + "WHERE UserName = '"+username+"'  && Password = '"+ password +"'");

            PreparedStatement searchUser = connection.prepareStatement(usersData);
            ResultSet resultSearchUser = searchUser.executeQuery();

            if (resultSearchUser.next()) {

                resultSearch = "usuario encontrado";

            } else {

                resultSearch = "usuario no encontardo";

            }

            connection.close();

        }catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        }

        return resultSearch;
    }
    
}
      

