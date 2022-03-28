package User;

import NetWork.DataBaseData;
import javax.swing.*;
import java.sql.*;

public class Customer {
    public static String name;
    public static String lastName;
    public static String email;
    public static String cellPhone;
    public static String gender;
    public static String userName;
    public static String password;
    public static String popCoins;
    public static String loginCounter;
    public static String dailyChallenges;
    public static String weeklyChallenges;
    public static String chalaCoins;
    public static String dailyTasks;
    public static String weeklyTasks;
    public static byte avatar;

    public static void updatePopCoins() {
        Connection connection;
        
        String sql = "UPDATE Data SET PopCoins=? WHERE UserName=?";
        
        try {
            connection = DataBaseData.connect();
            PreparedStatement searchData = connection.prepareStatement(sql);
            searchData.setString(1, popCoins);
            searchData.setString(2, userName);
            searchData.executeUpdate();
            connection.close();
           
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}