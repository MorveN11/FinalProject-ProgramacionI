package Utility;


import NetWork.DataBaseChallenges;
import NetWork.DataBaseData;
import NetWork.DataBaseMovie;
import Panels.HomeScreenLoget;
import Panels.RankMovies;
import User.Admin;
import User.Customer;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import static javax.swing.JOptionPane.*;

public class Utilities {

    
    public FileInputStream fis;
    public int longitudBytes;
    
    public static String name2DMovie1;
    public static String hourMor2DMovie1;
    public static String hourAft2DMovie1;
    public static String hourNig2DMovie1;
    public static String genre2DMovie1;
    public static String type2DMovie1;
    public static ImageIcon image2DMovie1;
    
    public static String name2DMovie2;
    public static String hourMor2DMovie2;
    public static String hourAft2DMovie2;
    public static String hourNig2DMovie2;
    public static String genre2DMovie2;
    public static String type2DMovie2;
    public static ImageIcon image2DMovie2;
    
    public static String name3DMovie;
    public static String hourMor3DMovie;
    public static String hourAft3DMovie;
    public static String hourNig3DMovie;
    public static String genre3DMovie;
    public static String type3DMovie;
    public static ImageIcon image3DMovie;
    
    public static String namePM;
    public static String hourMorPM;
    public static String hourAftPM;
    public static String hourNigPM;
    public static String genrePM;
    public static String typePM;
    public static ImageIcon imagePM;

    public static boolean verifyLarge(String password) {
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            count++;
        }
        return count > 7 && count < 16;
    }

    public static int verifyInt(String text) {
        Scanner scanner = new Scanner(System.in);
        boolean condition;
        int number = 0;
        do {
            System.out.println(text);
            try {
                number = scanner.nextInt();
                condition = true;
            } catch (InputMismatchException ime) {
                System.out.println("Aviso! Solo numeros enteros son permitidos");
                scanner.next();
                condition = false;
            }
        } while (!condition);
        return number;
    }

    public static double verifyDouble(String text) {
        Scanner scanner = new Scanner(System.in);
        boolean condition = false;
        double number = 0;
        do {
            System.out.println(text);
            try {
                number = scanner.nextDouble();
                condition = true;
            } catch (InputMismatchException ime) {
                System.out.println("Aviso! Solo numeros decimales son permitidos");
                scanner.next();
            }
        } while (!condition);
        return number;
    }

    public static boolean verifyTableData(int numberLine) {
        if (numberLine > 0 && numberLine <= Admin.table.length) {
            return true;
        } else {
            System.out.println("Valor de fila invalido");
            return false;
        }
    }

    public static String[] auxCreateMovie(String cinema) {
        String[] data = new String[8];
        data[0] = getString("Elija el nombre de la pelicula");
        data[1] = getString("Ingrese la hora de la funcion de la Madrugada de la pelicula");
        data[2] = getString("Ingrese la hora de la funcion de la Tarde de la pelicula");
        data[3] = getString("Ingrese la hora de la funcion de la Noche de la pelicula");
        double rating = verifyDouble("Ingrese el rating de la pelicula");
        int price = verifyInt("Ingrese el precio del Ticket");
        data[4] = String.valueOf(totalStatistics(rating, price, cinema));
        data[5] = String.valueOf(rating);
        data[6] = getString("Ingrese el genero de la pelicula");
        data[7] = String.valueOf(price);
        return data;
    }

    public static String confirmReset(String text) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(text);
            String message = scanner.next();
            message = message.toLowerCase();
            message = message.replace(".", "");
            if (message.equals("yes")) {
                return "yes";
            } else if (message.equals("no")) {
                return "no";
            } else {
                System.out.println("Ingrese un valor valido");
            }
        } while (true);
    }

    public static boolean verifyDBDailyChallenges(int number) {
        if (number > 0 && number <= DataBaseChallenges.indexDailyTasks()) {
            return true;
        } else {
            System.out.println("Valor de fila invalido");
            return false;
        }
    }

    public static boolean verifyDBWeeklyChallenges(int number) {
        if (number > 0 && number <= DataBaseChallenges.indexWeeklyTasks()) {
            return true;
        } else {
            System.out.println("Valor de fila invalido");
            return false;
        }
    }

    public static void confirmDeleteUser() {
        boolean condition;
        int line;
        do {
            line = Utilities.verifyInt("Eliga la fila del usuario que desea eliminar");
            condition = Utilities.verifyTableData(line);
        } while (!condition);
        Admin.deleteUser(line);
    }

    public static void confirmNameMovie(String cinema, String txtNameMovie) {
        String nameMovie = JOptionPane.showInputDialog(null, txtNameMovie, null,
                INFORMATION_MESSAGE);
        if (nameMovie != null) {
            DataBaseMovie.updateInfoMovie(cinema, nameMovie, "NameMovie");
            JOptionPane.showMessageDialog(null, "El nombre de la pelicula se ha " +
                    "actualizado con exito!!", null, INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hubo cambios", null,
                    ERROR_MESSAGE);
        }
    }

    public static void confirmHourMorMovie(String cinema, String txtHour) {
        String hourMovie = JOptionPane.showInputDialog(null, txtHour, null,
                INFORMATION_MESSAGE);
        if (hourMovie != null) {
            DataBaseMovie.updateInfoMovie(cinema, hourMovie, "HourMor");
            JOptionPane.showMessageDialog(null, "La hora de la pelicula se ha " +
                    "actualizado con exito!!", null, INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hubo cambios", null,
                    ERROR_MESSAGE);
        }
    }

    public static void confirmHourAftMovie(String cinema, String txtHour) {
        String hourMovie = JOptionPane.showInputDialog(null, txtHour, null,
                INFORMATION_MESSAGE);
        if (hourMovie != null) {
            DataBaseMovie.updateInfoMovie(cinema, hourMovie, "HourAft");
            JOptionPane.showMessageDialog(null, "La hora de la pelicula se ha " +
                    "actualizado con exito!!", null, INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hubo cambios", null,
                    ERROR_MESSAGE);
        }
    }

    public static void confirmHourNigMovie(String cinema, String txtHour) {
        String hourMovie = JOptionPane.showInputDialog(null, txtHour, null,
                INFORMATION_MESSAGE);
        if (hourMovie != null) {
            DataBaseMovie.updateInfoMovie(cinema, hourMovie, "HourNig");
            JOptionPane.showMessageDialog(null, "La hora de la pelicula se ha " +
                    "actualizado con exito!!", null, INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hubo cambios", null,
                    ERROR_MESSAGE);
        }
    }

    public static void confirmStatisticsMovie(String cinema, String txtStatistics) {
        String statisticsMovie = JOptionPane.showInputDialog(null, txtStatistics, null,
                INFORMATION_MESSAGE);
        if (statisticsMovie != null) {
            DataBaseMovie.updateInfoMovie(cinema, statisticsMovie, "Statistics");
            JOptionPane.showMessageDialog(null, "Las estadisticas de la pelicula " +
                    "se ha actualizado con exito!!", null, INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hubo canbios", null,
                    ERROR_MESSAGE);
        }
    }

    public static void confirmRatingMovie(String cinema, String txtRating) {
        String ratingMovie = JOptionPane.showInputDialog(null, txtRating, null,
                INFORMATION_MESSAGE);
        if (ratingMovie != null) {
            DataBaseMovie.updateInfoMovie(cinema, ratingMovie, "Rating");
            JOptionPane.showMessageDialog(null, "El rating de la pelicula " +
                    "se ha actualizado con exito!!", null, INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hubo cambios", null,
                    ERROR_MESSAGE);
        }
    }

    public static void confirmGenreMovie(String cinema, String txtGenre) {
        String genreMovie = JOptionPane.showInputDialog(null, txtGenre, null,
                INFORMATION_MESSAGE);
        if (genreMovie != null) {
            DataBaseMovie.updateInfoMovie(cinema, genreMovie, "Genre");
            JOptionPane.showMessageDialog(null, "El genero de la pelicula " +
                    "se ha actualizado con exito!!", null, INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hubo cambios", null,
                    ERROR_MESSAGE);
        }
    }

    public static void confirmPriceMovie(String cinema, String txtGenre) {
        String genreMovie = JOptionPane.showInputDialog(null, txtGenre, null,
                INFORMATION_MESSAGE);
        if (genreMovie != null) {
            DataBaseMovie.updateInfoMovie(cinema, genreMovie, "TicketPrice");
            JOptionPane.showMessageDialog(null, "El genero de la pelicula " +
                    "se ha actualizado con exito!!", null, INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hubo cambios", null,
                    ERROR_MESSAGE);
        }
    }

    public static void confirmNewDailyChallenge() {
        String message = JOptionPane.showInputDialog(null, "Como se llamara la " +
                "nueva tarea diaria?", null, INFORMATION_MESSAGE);
        if (message != null) {
            DataBaseChallenges.createDailyTask(message);
            JOptionPane.showMessageDialog(null, "La tarea diaria se creo con exito",
                    null, INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "La tarea diaria no se creo",
                    null, ERROR_MESSAGE);
        }
    }

    public static void confirmUpdateDailyChallenges() {
        int secure = JOptionPane.showConfirmDialog(null, "Desea reiniciar las tareas " +
                "diarias de los usuarios", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (OK_OPTION == secure) {
            DataBaseChallenges.updateDailyTasks();
            JOptionPane.showMessageDialog(null, "Los retos diarios han sido cambiados",
                    null, INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se reinciarion los retos diarios de " +
                    "los usuarios", null, ERROR_MESSAGE);
        }
    }

    public static void confirmDeleteDailyChallenge() {
        boolean condition;
        int line;
        do {
            line = Utilities.verifyInt("Eliga la fila de reto diario dese Eliminar?");
            condition = Utilities.verifyDBDailyChallenges(line);
        } while (!condition);
        DataBaseChallenges.deleteDailyTasks(line);
    }


    public static void confirmNewWeeklyChallenge() {
        String message = JOptionPane.showInputDialog(null, "Como se llamara la " +
                "nueva tarea semanal?", null, INFORMATION_MESSAGE);
        if (message != null) {
            DataBaseChallenges.createWeeklyTask(message);
            JOptionPane.showMessageDialog(null, "La tarea semanal se creo con exito",
                    null, INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "La tarea semanal no se creo",
                    null, ERROR_MESSAGE);
        }
    }

    public static void confirmUpdateWeeklyChallenge() {
        int secure = JOptionPane.showConfirmDialog(null, "Desea reiniciar las tareas " +
                "semanales de los usuarios", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (OK_OPTION == secure) {
            DataBaseChallenges.updateWeeklyTasks();
            JOptionPane.showMessageDialog(null, "Los retos semanales han sido cambiados",
                    null, INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se reiniciaron los retos semanales de " +
                    "los usuarios", null, ERROR_MESSAGE);
        }
    }

    public static void confirmDeleteWeeklyChallenge() {
        boolean condition;
        int line;
        do {
            line = Utilities.verifyInt("Eliga la fila de reto semanal dese Eliminar?");
            condition = Utilities.verifyDBWeeklyChallenges(line);
        } while (!condition);
        DataBaseChallenges.deleteWeeklyTasks(line);
    }


    public void searchImage() {
        JFileChooser se = new JFileChooser();
        se.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = se.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {

                fis = new FileInputStream(se.getSelectedFile());
                this.longitudBytes = (int) se.getSelectedFile().length();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Error en el primer catch");
            }
        }
    }

    public void saveImage(String cinema) {
        try {

            Connection cn = DataBaseData.connect();
            PreparedStatement pst = cn.prepareStatement("UPDATE " + cinema + " SET Image=? WHERE RowLetter=?");

            pst.setBlob(1, fis, longitudBytes);
            pst.setString(2, "A");
            pst.executeUpdate();
            cn.close();
            JOptionPane.showMessageDialog(null, "Registro Exitoso");

        } catch (SQLException e) {
            System.out.println("Error al guardar foto " + e);
            JOptionPane.showMessageDialog(null, "¡¡Error al guardar foto!!");
        }

    }

    public static String getString(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        return scanner.next();
    }

    public static void showMovie(String cinema) {
        String[] data = DataBaseMovie.showInfoMovie(cinema);
        System.out.println(Arrays.toString(data));
    }

    public static void auxCreate2DMovie(String cinema, int numberCinema) {
        String[] data = Utilities.auxCreateMovie("2D");
        DataBaseMovie.create2DMovie(numberCinema, data[0], data[1], data[2], data[3], data[4],
                data[5], data[6], data[7]);
        Utilities saveImage = new Utilities();
        saveImage.searchImage();
        saveImage.saveImage(cinema);
    }

    public static void auxCreate3DMovie() {
        String[] data = Utilities.auxCreateMovie("3D");
        DataBaseMovie.create3DMovie(data[0], data[1], data[2], data[3], data[4], data[5],
                data[6], data[7]);
        Utilities saveImage = new Utilities();
        saveImage.searchImage();
        saveImage.saveImage("3DMovie");
    }

    public static void auxCreatePremiumMovie() {
        String[] data = Utilities.auxCreateMovie("PremiumMovie");
        DataBaseMovie.createPremiumMovie(data[0], data[1], data[2], data[3], data[4], data[5],
                data[6], data[7]);
        Utilities saveImage = new Utilities();
        saveImage.searchImage();
        saveImage.saveImage("PremiumMovie");
    }
    
    public static int totalStatistics(double rating, int price, String cinema) {
        int totalEarnings, seats;
        if (cinema.equals("2D")) {
            seats = 36;
        } else if (cinema.equals("3D")) {
            seats = 64;
        } else {
            seats = 100;
        }
        totalEarnings = (((int)((rating * 10) * seats) / 100) * price);
        return totalEarnings;
    }
    
    public static void load2DMovie1() {
        java.sql.Connection connection;
        String dbMovie = "SELECT NameMovie, HourMor, HourAft, HourNig, Genre, "
                + "Type, Image FROM 2DMovie1";
        try {
            connection = DataBaseData.connect();
            PreparedStatement searchData = connection.prepareStatement(dbMovie);
            ResultSet resultSearch = searchData.executeQuery();
            if(resultSearch.next()) {
                name2DMovie1 = resultSearch.getNString("NameMovie");
                hourMor2DMovie1 = resultSearch.getString("HourMor");
                hourAft2DMovie1 = resultSearch.getString("HourAft");
                hourNig2DMovie1 = resultSearch.getString("HourNig");
                genre2DMovie1 = resultSearch.getString("Genre");
                type2DMovie1 = resultSearch.getString("Type");
                Blob blob = resultSearch.getBlob("Image");
                byte[] data = blob.getBytes(1, (int) blob.length());
                BufferedImage img = null;
                    try {
                        img = ImageIO.read(new ByteArrayInputStream(data));
                    } catch (IOException e) {
                        Logger.getLogger(HomeScreenLoget.class.getName()).log(Level.SEVERE, null, e);
                    } 
                    image2DMovie1 = new ImageIcon(img);
            }
            connection.close();
        } catch(SQLException e) {
            
            System.out.println(e);
        } 
    }
    public static void load2DMovie2() {
        java.sql.Connection connection;
        String dbMovie = "SELECT NameMovie, HourMor, HourAft, HourNig, Genre, "
                + "Type, Image FROM 2DMovie2";
        try {
            connection = DataBaseData.connect();
            PreparedStatement searchData = connection.prepareStatement(dbMovie);
            ResultSet resultSearch = searchData.executeQuery();
            if(resultSearch.next()) {
                name2DMovie2 = resultSearch.getNString("NameMovie");
                hourMor2DMovie2 = resultSearch.getString("HourMor");
                hourAft2DMovie2 = resultSearch.getString("HourAft");
                hourNig2DMovie2 = resultSearch.getString("HourNig");
                genre2DMovie2 = resultSearch.getString("Genre");
                type2DMovie2 = resultSearch.getString("Type");
                Blob blob = resultSearch.getBlob("Image");
                byte[] data = blob.getBytes(1, (int) blob.length());
                BufferedImage img = null;
                    try {
                        img = ImageIO.read(new ByteArrayInputStream(data));
                    } catch (IOException e) {
                        Logger.getLogger(HomeScreenLoget.class.getName()).log(Level.SEVERE, null, e);
                    } 
                    image2DMovie2 = new ImageIcon(img);
            }
            connection.close();
        } catch(SQLException e) {
            
            System.out.println(e);
        } 
    }
    
    public static void load3DMovie() {
        java.sql.Connection connection;
        String dbMovie = "SELECT NameMovie, HourMor, HourAft, HourNig, Genre, "
                + "Type, Image FROM 3DMovie";
        try {
            connection = DataBaseData.connect();
            PreparedStatement searchData = connection.prepareStatement(dbMovie);
            ResultSet resultSearch = searchData.executeQuery();
            if(resultSearch.next()) {
                name3DMovie = resultSearch.getNString("NameMovie");
                hourMor3DMovie = resultSearch.getString("HourMor");
                hourAft3DMovie = resultSearch.getString("HourAft");
                hourNig3DMovie = resultSearch.getString("HourNig");
                genre3DMovie = resultSearch.getString("Genre");
                type3DMovie = resultSearch.getString("Type");
                Blob blob = resultSearch.getBlob("Image");
                byte[] data = blob.getBytes(1, (int) blob.length());
                BufferedImage img = null;
                    try {
                        img = ImageIO.read(new ByteArrayInputStream(data));
                    } catch (IOException e) {
                        Logger.getLogger(HomeScreenLoget.class.getName()).log(Level.SEVERE, null, e);
                    } 
                    image3DMovie = new ImageIcon(img);
            }
            connection.close();
        } catch(SQLException e) {
            
            System.out.println(e);
        } 
    }
    public static void loadPM() {
        java.sql.Connection connection;
        String dbMovie = "SELECT NameMovie, HourMor, HourAft, HourNig, Genre, "
                + "Type, Image FROM PremiumMovie";
        try {
            connection = DataBaseData.connect();
            PreparedStatement searchData = connection.prepareStatement(dbMovie);
            ResultSet resultSearch = searchData.executeQuery();
            if(resultSearch.next()) {
                namePM = resultSearch.getNString("NameMovie");
                hourMorPM = resultSearch.getString("HourMor");
                hourAftPM = resultSearch.getString("HourAft");
                hourNigPM = resultSearch.getString("HourNig");
                genrePM = resultSearch.getString("Genre");
                typePM = resultSearch.getString("Type");
                Blob blob = resultSearch.getBlob("Image");
                byte[] data = blob.getBytes(1, (int) blob.length());
                BufferedImage img = null;
                    try {
                        img = ImageIO.read(new ByteArrayInputStream(data));
                    } catch (IOException e) {
                        Logger.getLogger(HomeScreenLoget.class.getName()).log(Level.SEVERE, null, e);
                    } 
                    imagePM = new ImageIcon(img);
            }
            connection.close();
        } catch(SQLException e) {
            
            System.out.println(e);
        } 
    }
    
    public static void loadCine() {
        load2DMovie1();
        load2DMovie2();
        load3DMovie();
        loadPM();
    }
    
    public static void rankingMovie(String movie) {
        int secure = JOptionPane.showConfirmDialog(null, "Gracias por ver: "+movie+"\n"
                 + "¿Quiere rankear la pelicula?", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (OK_OPTION == secure) {
            RankMovies show = new RankMovies();
            show.setVisible(true);
        } else{
            JOptionPane.showMessageDialog(null, "Muchas gracias por se preferencia: "+Customer.name+" "+
                    Customer.lastName+"\n Que tenga un buen dia!");
        }
        
    }
    
    public static void commentMovie(String movie) {
        
        int result;
        int secure = JOptionPane.showConfirmDialog(null, "Gracias por ver: "+movie+"\n"
                 + "¿Quiere dar un comentario sobre la pelicula?", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (OK_OPTION == secure) {
            
            String comment = JOptionPane.showInputDialog(null, "Ingrese su comentario");
            if (comment!=null){
                Connection connection;
                String sql = "INSERT INTO Comments (NameMovie, UserName, Comment) VALUES (?, ?, ?)";
            
            try {
                connection = DataBaseData.connect();
                PreparedStatement insert = connection.prepareStatement(sql);
                insert.setString(1, movie);
                insert.setString(2, Customer.name);
                insert.setString(3, comment);
                result = insert.executeUpdate();
                if(result>0) {
                    JOptionPane.showMessageDialog(null, "El comentario se guardo con exito");
                }
                connection.close();
               
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
            }
        } else{
            JOptionPane.showMessageDialog(null, "Muchas gracias por su preferencia: "+Customer.name+" "+
                    Customer.lastName+"\n Que tenga un buen dia!");
        }    
    }
    
    public static double getRanking() {
        int indexRanking = 0;
        double result = 0;
        Connection connection;
        String sql = "SELECT "+HomeScreenLoget.cinema+" FROM Ranks";
        
        try {
            connection = DataBaseData.connect();
            PreparedStatement out = connection.prepareStatement(sql);
            ResultSet resultSearch = out.executeQuery();
            while (resultSearch.next()) {
                if(resultSearch.getString(HomeScreenLoget.cinema) != null){
                    result += Integer.valueOf(resultSearch.getString(HomeScreenLoget.cinema));
                    indexRanking++;
                }
            } 
            connection.close();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        if (indexRanking > 1) {
            return result/indexRanking;
        } else {
            return result;
        }
    }
    
    public static void saveRank(int rank) {
       
       String sRank = String.valueOf(rank);
       Connection connection;
       String sql = "INSERT INTO Ranks ("+HomeScreenLoget.cinema+") VALUES (?)";
       
       try {
           connection = DataBaseData.connect();
           PreparedStatement insert = connection.prepareStatement(sql);
           insert.setString(1, sRank);
           insert.executeUpdate();
           connection.close();
       } catch(SQLException e) {
           JOptionPane.showMessageDialog(null, e);
       }   
    }

    public static void sendRank(double ranking) {
        
        String rank = String.valueOf(ranking);
        Connection connection;
        String sql = "UPDATE "+HomeScreenLoget.cinema+" SET Ranks=? WHERE RowLetter=?";
        
        try {
            connection = DataBaseData.connect();
            PreparedStatement insert = connection.prepareStatement(sql);
            insert.setString(1, rank);
            insert.setString(2, "A");
            insert.executeUpdate();
            connection.close();
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } 
    }
    
    public static String giveDailyTasks() {
        
        String DailyTasks = null;
        
        Connection connection;
        String sql = "SELECT DailyChallenges FROM Data WHERE UserName=?";
        try {
            
            connection = DataBaseData.connect();
            PreparedStatement insert = connection.prepareStatement(sql);
            insert.setString(1, Customer.userName);
            ResultSet result = insert.executeQuery();
            if(result.next()) {
        
                DailyTasks = result.getString("DailyChallenges");
     
            }
           
            connection.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return DailyTasks;
    }
    
    public static String giveWeeklyTasks() {
        
        String DailyTasks = null;
        
        Connection connection;
        String sql = "SELECT WeeklyChallenges FROM Data WHERE UserName=?";
        try {
            
            connection = DataBaseData.connect();
            PreparedStatement insert = connection.prepareStatement(sql);
            insert.setString(1, Customer.userName);
            ResultSet result = insert.executeQuery();
            if(result.next()) {
        
                DailyTasks = result.getString("WeeklyChallenges");
     
            }
           
            connection.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return DailyTasks;
    }
 }
