package NetWork;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class DataBaseData {

    public static String[][] table;
    public static ArrayList<String> userNameData = new ArrayList<>();
    public static ArrayList<String> cellPhoneData = new ArrayList<>();
    public static ArrayList<String> emailData = new ArrayList<>();
    public static int dbPort = 12447;
    public static String dbServer = "mysql-72602-0.cloudclusters.net";
    public static String dbName = "UsersLogin";
    public static String userName = "admin";
    public static String password = "Jye0g2UG";
    public static String url = "jdbc:mysql://" + dbServer + ":" + dbPort + "/" + dbName+"?characterEncoding=utf8";

    public static Connection connect() throws SQLException {

        Connection connection = null;

        try {

            Class.forName("org.gjt.mm.mysql.Driver");
            connection = DriverManager.getConnection(url, userName, password);

        }catch(ClassNotFoundException | SQLException ex) {

            JOptionPane.showMessageDialog(null, ex);
        }
        return connection;
    }

    public static int saveData(String txtNames, String txtLastNames, String txtEmail, String txtCellPhone,
                               String txtGender, String txtUsername, String txtPassword) {

        int resultSaveData = 0;
        Connection connection = null;
        String usersData = "INSERT INTO Data (Name, LastName, Email, CellPhone, Gender, UserName, Password) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {

            connection = connect();

            try(PreparedStatement searchUsersData = connection.prepareStatement(usersData)) {

                searchUsersData.setString(1, txtNames);
                searchUsersData.setString(2, txtLastNames);
                searchUsersData.setString(3, txtEmail);
                searchUsersData.setString(4, txtCellPhone);
                searchUsersData.setString(5, txtGender);
                searchUsersData.setString(6, txtUsername);
                searchUsersData.setString(7, txtPassword);
                resultSaveData = searchUsersData.executeUpdate();
            }
        }catch(SQLException e) {

            JOptionPane.showMessageDialog(null, "Error trying to store information:\n"
                    + e, "Operation Failed", JOptionPane.ERROR_MESSAGE);
        }finally {

            try {
                if(connection!=null) {
                    connection.close();
                }
            }catch(SQLException ex) {

                JOptionPane.showMessageDialog(null, "Error when trying to close the connection:\n"
                        + ex, "Operation Failed", JOptionPane.ERROR_MESSAGE);
            }
        }
        return resultSaveData;
    }

    public static String searchUser(String userName) {

        String searchUser = null;
        Connection connection;

        try {

            connection = connect();
            String usersData = ("SELECT Name, LastName FROM Data WHERE UserName = '" + userName + "'");
            PreparedStatement searchUserName = connection.prepareStatement(usersData);
            ResultSet resultSearch = searchUserName.executeQuery();

            if(resultSearch.next()) {

                String names = resultSearch.getString("Name");
                String lastNames = resultSearch.getString("LastName");
                searchUser = (names +" "+ lastNames);
            }
            connection.close();

        } catch(SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }
        return searchUser;
    }

    public static String searchRegisteredUser(String username, String password) {

        String resultSearch = null;
        Connection connection;

        try {

            connection = connect();
            String usersData = ("SELECT Name, UserName, Password FROM Data "
                    + "WHERE UserName = '"+username+"'  && Password = '"+ password +"'");
            PreparedStatement searchUser = connection.prepareStatement(usersData);
            ResultSet resultSearchUser = searchUser.executeQuery();

            if(resultSearchUser.next()) {

                resultSearch = "Found User";
            }else {

                resultSearch = "User not Found";
            }
            connection.close();

        }catch(SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }
        return resultSearch;
    }

    public static void searchDataUsers() {

        String usersData = "SELECT *FROM Data";
        Connection connection;
        int fCount = 0;

        try {

            connection = connect();
            PreparedStatement searchUsersData = connection.prepareStatement(usersData);
            ResultSet resultSearch = searchUsersData.executeQuery();

            while (resultSearch.next()){
                fCount += 1;
            }
            connection.close();

        }catch(SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }
        table = new String[fCount][7];
        fCount = 0;

        try {

            connection = connect();
            PreparedStatement searchUsersData = connection.prepareStatement(usersData);
            ResultSet resultSearch = searchUsersData.executeQuery();

            while (resultSearch.next()) {

                table[fCount][0] = resultSearch.getString("Name");
                table[fCount][1] = resultSearch.getString("LastName");
                table[fCount][2] = resultSearch.getString("Email");
                table[fCount][3] = resultSearch.getString("CellPhone");
                table[fCount][4] = resultSearch.getString("Gender");
                table[fCount][5] = resultSearch.getString("UserName");
                table[fCount][6] = resultSearch.getString("Password");
                fCount += 1;
            }
            connection.close();

        }catch(SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void verifyData() {

        String usersData = "SELECT Email, UserName, CellPhone FROM Data";
        Connection connection;

        try {
            connection = connect();

            PreparedStatement searchUsersData = connection.prepareStatement(usersData);
            ResultSet resultSearch = searchUsersData.executeQuery();

            while(resultSearch.next()) {
                emailData.add(resultSearch.getString("Email"));
                userNameData.add(resultSearch.getString("UserName"));
                cellPhoneData.add(resultSearch.getString("CellPhone"));
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static boolean isRepeated(String inputData, String type) {
        if (type.equals("UserName")) {
            for (String data : userNameData) {
                if (data.equals(inputData)) {
                    return false;
                }
            }
        } else if (type.equals("CellPhone")) {
            for (String data : cellPhoneData) {
                if (data.equals(inputData)) {
                    return false;
                }
            }
        } else {
            for (String data : emailData) {
                if (data.equals(inputData)) {
                    return false;
                }
            }
        }
        return true;
    }

}
