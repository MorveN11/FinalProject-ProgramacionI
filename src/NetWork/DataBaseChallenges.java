package NetWork;


import User.Admin;
import User.Customer;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static javax.swing.JOptionPane.*;


public class DataBaseChallenges {

    public static String[][] dailyTasks;
    public static String[][] weeklyTasks;
    public static int numberDailyTasks = 5;
    public static int numberWeeklyTasks = 3;

    public static void cleanDataBaseChallenges() {
        DataBaseData.searchDataUsers();
        Connection connection;

        String dataUser = "DELETE FROM Data WHERE Name=?";
        try {
            connection = DataBaseData.connect();
            PreparedStatement searchDataUsers = connection.prepareStatement(dataUser);
            searchDataUsers.setString(1, DataBaseData.table[0][0]);
            searchDataUsers.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static int indexDailyTasks() {
        Connection connection;
        String tasksChallenges = "SELECT *FROM DailyTasks";
        int count = 0;
        try {
            connection = DataBaseData.connect();
            PreparedStatement searchTasks = connection.prepareStatement(tasksChallenges);
            ResultSet resultSearch = searchTasks.executeQuery();
            while(resultSearch.next()) {
                count++;
            }
            connection.close();

        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return count;
    }

    public static void createDailyTask(String newChallenge) {
        Connection connection;
        String tasksChallenges = "INSERT INTO DailyTasks (Challenges, Tasks) Values (?, ?)";
        int index = indexDailyTasks();

        try {
            connection = DataBaseData.connect();
            PreparedStatement searchTasks = connection.prepareStatement(tasksChallenges);
            searchTasks.setString(1, "Challenge"+index);
            searchTasks.setString(2, newChallenge);
            searchTasks.executeUpdate();
            connection.close();

        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void getDailyTasks() {
        int index = indexDailyTasks();
        dailyTasks = new String[index][2];
        Connection connection;
        String tasksChallenges = "SELECT *FROM DailyTasks";
        int count=0;

        try {
            connection = DataBaseData.connect();
            PreparedStatement searchTasks = connection.prepareStatement(tasksChallenges);
            ResultSet resultSearch = searchTasks.executeQuery();
            while(resultSearch.next()) {
                dailyTasks[count][0] = resultSearch.getString("Challenges");
                dailyTasks[count][1] = resultSearch.getString("Tasks");
                count++;
            }
            connection.close();

        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void showDailyTasks() {
        getDailyTasks();
        int count = 1;
        for (String[] line : dailyTasks) {
            System.out.print(count + ".- ");
            System.out.print("[");
            for (int i = 0; i < line.length; i++) {
                System.out.print(line[i]);
                if (i != line.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
            count++;
        }
    }

    public static String[] saveDailyTasks() {
        String[] saveDailyTasks = new String[numberDailyTasks];
        int[] numbers = new int[numberDailyTasks];
        int count = 0;
        do {
            int number = (int) (Math.random() * dailyTasks.length);
            for (int i = 0; i < numbers.length; i++) {
                if(number == numbers[i]) {
                    number = (int) (Math.random() * dailyTasks.length);
                    i = -1;
                }
            }
            numbers[count] = number;
            count++;
        } while(count < saveDailyTasks.length);
        count = 0;
        for (int num : numbers) {
            saveDailyTasks[count] = dailyTasks[num][1];
            count++;
        }
        return saveDailyTasks;
    }

    public static void saveUsersDailyTasks() {
        DataBaseData.searchDataUsers();
        Connection connection;
        String dataUser = "SELECT Name, LastName, Email, CellPhone, Gender," +
                "UserName, Password, PopCoins, LoginCounter, WeeklyChallenges, ChalaCoins, " +
                "Avatar FROM Data WHERE Name = '" + DataBaseData.table[0][0] + "'";
        try {
            connection = DataBaseData.connect();
            PreparedStatement searchDataUsers = connection.prepareStatement(dataUser);
            ResultSet resultSearch = searchDataUsers.executeQuery();

            if(resultSearch.next()) {
                Customer.name = resultSearch.getString("Name");
                Customer.lastName = resultSearch.getString("LastName");
                Customer.email = resultSearch.getString("Email");
                Customer.cellPhone = resultSearch.getString("Cellphone");
                Customer.gender = resultSearch.getString("Gender");
                Customer.userName = resultSearch.getString("UserName");
                Customer.password = resultSearch.getString("Password");
                Customer.popCoins = resultSearch.getString("PopCoins");
                Customer.loginCounter = resultSearch.getString("LoginCounter");
                Customer.weeklyChallenges = resultSearch.getString("WeeklyChallenges");
                Customer.chalaCoins = resultSearch.getString("ChalaCoins");
                Customer.avatar = resultSearch.getByte("Avatar");
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void sendDailyTasks() {
        DataBaseData.searchDataUsers();
        String[] saveDailyTasks = saveDailyTasks();
        Connection connection;

        String dataUser = "INSERT INTO Data (Name, LastName, Email, CellPhone, Gender, UserName, Password, PopCoins, " +
                "LoginCounter, DailyChallenges, WeeklyChallenges, ChalaCoins, Avatar) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            connection = DataBaseData.connect();
            PreparedStatement searchDataUsers = connection.prepareStatement(dataUser);
            searchDataUsers.setString(1, Customer.name);
            searchDataUsers.setString(2, Customer.lastName);
            searchDataUsers.setString(3, Customer.email);
            searchDataUsers.setString(4, Customer.cellPhone);
            searchDataUsers.setString(5, Customer.gender);
            searchDataUsers.setString(6, Customer.userName);
            searchDataUsers.setString(7, Customer.password);
            searchDataUsers.setString(8, Customer.popCoins);
            searchDataUsers.setString(9, Customer.loginCounter);
            searchDataUsers.setString(10, "["+saveDailyTasks[0]+", "+saveDailyTasks[1]+", "+
                    saveDailyTasks[2]+", "+saveDailyTasks[3]+", "+saveDailyTasks[4]+"]");
            searchDataUsers.setString(11, Customer.weeklyChallenges);
            searchDataUsers.setString(12, Customer.chalaCoins);
            searchDataUsers.setByte(13, Customer.avatar);
            searchDataUsers.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void updateDailyTasks() {
        getDailyTasks();
        int count = 0;
        while (count < Admin.table.length) {
            DataBaseChallenges.saveUsersDailyTasks();
            DataBaseChallenges.getDailyTasks();
            DataBaseChallenges.cleanDataBaseChallenges();
            DataBaseChallenges.sendDailyTasks();
            count++;
        }
    }

    public static void deleteDailyTasks(int line) {
        int secure = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el " +
                "'Challenge"+(line-1)+"'", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (OK_OPTION == secure) {
            Connection connection;
            String tasksChallenges = "DELETE FROM DailyTasks WHERE Challenges=?";
            try {
                connection = DataBaseData.connect();
                PreparedStatement searchTask = connection.prepareStatement(tasksChallenges);
                searchTask.setString(1, "Challenge" + (line - 1));
                searchTask.executeUpdate();
                connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            updateDBDailyTasks();
            JOptionPane.showMessageDialog(null, "La tarea diaria se elimino con exito!!", null,
                    INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "La tarea diario no se elimino", null,
                    ERROR_MESSAGE);
        }
    }

    public static void cleanDailyTasks() {
        Connection connection;
        String tasksChallenges = "TRUNCATE DailyTasks";
        try{
            connection = DataBaseData.connect();
            PreparedStatement searchTask = connection.prepareStatement(tasksChallenges);
            searchTask.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void updateDBDailyTasks() {
        getDailyTasks();
        cleanDailyTasks();
        for (String[] task : dailyTasks) {
            createDailyTask(task[1]);
        }
    }

    public static int indexWeeklyTasks() {
        Connection connection;
        String tasksChallenges = "SELECT *FROM WeeklyTasks";
        int count = 0;
        try {
            connection = DataBaseData.connect();
            PreparedStatement searchTasks = connection.prepareStatement(tasksChallenges);
            ResultSet resultSearch = searchTasks.executeQuery();
            while(resultSearch.next()) {
                count++;
            }
            connection.close();

        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return count;
    }

    public static void createWeeklyTask(String newChallenge) {
        Connection connection;
        String tasksChallenges = "INSERT INTO WeeklyTasks (Challenges, Tasks) Values (?, ?)";
        int index = indexWeeklyTasks();

        try {
            connection = DataBaseData.connect();
            PreparedStatement searchTasks = connection.prepareStatement(tasksChallenges);
            searchTasks.setString(1, "Challenge"+index);
            searchTasks.setString(2, newChallenge);
            searchTasks.executeUpdate();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void getWeeklyTasks() {
        int index = indexWeeklyTasks();
        weeklyTasks = new String[index][2];
        Connection connection;
        String tasksChallenges = "SELECT *FROM WeeklyTasks";
        int count=0;

        try {
            connection = DataBaseData.connect();
            PreparedStatement searchTasks = connection.prepareStatement(tasksChallenges);
            ResultSet resultSearch = searchTasks.executeQuery();
            while(resultSearch.next()) {
                weeklyTasks[count][0] = resultSearch.getString("Challenges");
                weeklyTasks[count][1] = resultSearch.getString("Tasks");
                count++;
            }
            connection.close();

        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void showWeeklyTasks() {
        getWeeklyTasks();
        int count = 1;
        for (String[] line : weeklyTasks) {
            System.out.print(count + ".- ");
            System.out.print("[");
            for (int i = 0; i < line.length; i++) {
                System.out.print(line[i]);
                if (i != line.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
            count++;
        }
    }

    public static String[] saveWeeklyTasks() {
        String[] saveWeeklyTasks = new String[numberWeeklyTasks];
        int[] numbers = new int[numberWeeklyTasks];
        int count = 0;
        do {
            int number = (int) (Math.random() * weeklyTasks.length);
            for (int i = 0; i < numbers.length; i++) {
                if(number == numbers[i]) {
                    number = (int) (Math.random() * weeklyTasks.length);
                    i = -1;
                }
            }
            numbers[count] = number;
            count++;
        } while(count < saveWeeklyTasks.length);
        count = 0;
        for (int num : numbers) {
            saveWeeklyTasks[count] = weeklyTasks[num][1];
            count++;
        }
        return saveWeeklyTasks;
    }

    public static void saveUsersWeeklyTasks() {
        DataBaseData.searchDataUsers();
        Connection connection;
        String dataUser = "SELECT Name, LastName, Email, CellPhone, Gender," +
                "UserName, Password, PopCoins, LoginCounter, DailyChallenges, ChalaCoins, " +
                "Avatar FROM Data WHERE Name = '" + DataBaseData.table[0][0] + "'";
        try {
            connection = DataBaseData.connect();
            PreparedStatement searchDataUsers = connection.prepareStatement(dataUser);
            ResultSet resultSearch = searchDataUsers.executeQuery();

            if(resultSearch.next()) {
                Customer.name = resultSearch.getString("Name");
                Customer.lastName = resultSearch.getString("LastName");
                Customer.email = resultSearch.getString("Email");
                Customer.cellPhone = resultSearch.getString("Cellphone");
                Customer.gender = resultSearch.getString("Gender");
                Customer.userName = resultSearch.getString("UserName");
                Customer.password = resultSearch.getString("Password");
                Customer.popCoins = resultSearch.getString("PopCoins");
                Customer.loginCounter = resultSearch.getString("LoginCounter");
                Customer.dailyChallenges = resultSearch.getString("DailyChallenges");
                Customer.chalaCoins = resultSearch.getString("ChalaCoins");
                Customer.avatar = resultSearch.getByte("Avatar");
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void sendWeeklyTasks() {
        DataBaseData.searchDataUsers();
        String[] saveWeeklyTasks = saveWeeklyTasks();
        Connection connection;

        String dataUser = "INSERT INTO Data (Name, LastName, Email, CellPhone, Gender, UserName, Password, PopCoins, " +
                "LoginCounter, DailyChallenges, WeeklyChallenges, ChalaCoins, Avatar) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            connection = DataBaseData.connect();
            PreparedStatement searchDataUsers = connection.prepareStatement(dataUser);
            searchDataUsers.setString(1, Customer.name);
            searchDataUsers.setString(2, Customer.lastName);
            searchDataUsers.setString(3, Customer.email);
            searchDataUsers.setString(4, Customer.cellPhone);
            searchDataUsers.setString(5, Customer.gender);
            searchDataUsers.setString(6, Customer.userName);
            searchDataUsers.setString(7, Customer.password);
            searchDataUsers.setString(8, Customer.popCoins);
            searchDataUsers.setString(9, Customer.loginCounter);
            searchDataUsers.setString(10, Customer.dailyChallenges);
            searchDataUsers.setString(11, "["+saveWeeklyTasks[0]+", "+saveWeeklyTasks[1]+", "+
                    saveWeeklyTasks[2]+"]");
            searchDataUsers.setString(12, Customer.chalaCoins);
            searchDataUsers.setByte(13, Customer.avatar);
            searchDataUsers.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void updateWeeklyTasks() {
        getWeeklyTasks();
        int count = 0;
        while (count < Admin.table.length) {
            DataBaseChallenges.saveUsersWeeklyTasks();
            DataBaseChallenges.getWeeklyTasks();
            DataBaseChallenges.cleanDataBaseChallenges();
            DataBaseChallenges.sendWeeklyTasks();
            count++;
        }
    }

    public static void deleteWeeklyTasks(int line) {
        int secure = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el" +
                "'Challenge"+(line-1)+"'", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (OK_OPTION == secure) {
            Connection connection;
            String tasksChallenges = "DELETE FROM WeeklyTasks WHERE Challenges=?";
            try {
                connection = DataBaseData.connect();
                PreparedStatement searchTask = connection.prepareStatement(tasksChallenges);
                searchTask.setString(1, "Challenge" + (line - 1));
                searchTask.executeUpdate();
                connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            updateDBWeeklyTasks();
            JOptionPane.showMessageDialog(null, "Se elimino el reto semanal de forma exitosa!!",
                    null, INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "La tarea semanal no se elimino", null,
                    ERROR_MESSAGE);
        }
    }

    public static void cleanWeeklyTasks() {
        Connection connection;
        String tasksChallenges = "TRUNCATE WeeklyTasks";
        try{
            connection = DataBaseData.connect();
            PreparedStatement searchTask = connection.prepareStatement(tasksChallenges);
            searchTask.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void updateDBWeeklyTasks() {
        getWeeklyTasks();
        cleanWeeklyTasks();
        for (String[] task : weeklyTasks) {
            createWeeklyTask(task[1]);
        }
    }

}
