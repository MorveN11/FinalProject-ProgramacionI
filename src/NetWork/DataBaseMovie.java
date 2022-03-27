package NetWork;

import javax.swing.*;
import java.sql.*;

public class DataBaseMovie {

    static int fill2DMovie(int cinema) {

        String[] rowLetters = {"B", "C", "D", "E", "F"};
        String available = "D";
        String cinemaDB = String.valueOf(cinema);
        int resultSaveData = 0;
        Connection connection = null;
        String movieData = "INSERT INTO 2DMovie"+cinemaDB+" (RowLetter, C1, C2, C3, C4, C5, C6) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {

            connection = DataBaseData.connect();

            for (String rowLetter : rowLetters) {
                try (PreparedStatement searchMovieData = connection.prepareStatement(movieData)) {

                    searchMovieData.setString(1, rowLetter);
                    searchMovieData.setString(2, available);
                    searchMovieData.setString(3, available);
                    searchMovieData.setString(4, available);
                    searchMovieData.setString(5, available);
                    searchMovieData.setString(6, available);
                    searchMovieData.setString(7, available);
                    resultSaveData = searchMovieData.executeUpdate();
                }
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

    public static void create2DMovie(int cinema, String nameMovie, String hour, String statistics,
                                     String rating, String genre) {

        String cinemaDB = String.valueOf(cinema);
        String rowLetter = "A";
        String available = "D";
        int resultSaveData;
        Connection connection = null;

        String movieData = "INSERT INTO 2DMovie"+cinemaDB+" (NameMovie, Hour, Statistics, Rating, Genre, " +
                "RowLetter, C1, C2, C3, C4, C5, C6) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            connection = DataBaseData.connect();

            try(PreparedStatement searchMovieData = connection.prepareStatement(movieData)) {

                searchMovieData.setString(1, nameMovie);
                searchMovieData.setString(2, hour);
                searchMovieData.setString(3, statistics);
                searchMovieData.setString(4, rating);
                searchMovieData.setString(5, genre);
                searchMovieData.setString(6, rowLetter);
                searchMovieData.setString(7, available);
                searchMovieData.setString(8, available);
                searchMovieData.setString(9, available);
                searchMovieData.setString(10, available);
                searchMovieData.setString(11, available);
                searchMovieData.setString(12, available);

                resultSaveData = searchMovieData.executeUpdate();

                if (resultSaveData > 0) {
                    JOptionPane.showMessageDialog(null, "La pelicula se creo con exito, porfavor " +
                            "espera a que se rellene la sala...");
                    int resultFill = fill2DMovie(cinema);
                    if (resultFill > 0) {
                        JOptionPane.showMessageDialog(null, "La pelicula se relleno con exito!!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Hubo un error al rellenar la " +
                                "pelicula");
                    }
                }
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
    }

    static int fill3DMovie(int cinema) {

        String[] rowLetters = {"B", "C", "D", "E", "F", "G", "H"};
        String available = "D";
        String cinemaDB = String.valueOf(cinema);
        int resultSaveData = 0;
        Connection connection = null;
        String movieData = "INSERT INTO 3DMovie"+cinemaDB+" (RowLetter, C1, C2, C3, C4, C5, C6, C7, C8) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            connection = DataBaseData.connect();

            for (String rowLetter : rowLetters) {
                try (PreparedStatement searchMovieData = connection.prepareStatement(movieData)) {

                    searchMovieData.setString(1, rowLetter);
                    searchMovieData.setString(2, available);
                    searchMovieData.setString(3, available);
                    searchMovieData.setString(4, available);
                    searchMovieData.setString(5, available);
                    searchMovieData.setString(6, available);
                    searchMovieData.setString(7, available);
                    searchMovieData.setString(8, available);
                    searchMovieData.setString(9, available);
                    resultSaveData = searchMovieData.executeUpdate();
                }
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

    public static void create3DMovie(int cinema, String nameMovie, String hour, String statistics,
                                     String rating, String genre) {

        String rowLetter = "A";
        String available = "D";
        String cinemaDB = String.valueOf(cinema);
        int resultSaveData;
        Connection connection = null;

        String movieData = "INSERT INTO 3DMovie"+cinemaDB+" (NameMovie, Hour, Statistics, Rating, Genre, RowLetter, C1, " +
                "C2,C3, C4, C5, C6, C7, C8) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            connection = DataBaseData.connect();

            try(PreparedStatement searchMovieData = connection.prepareStatement(movieData)) {

                searchMovieData.setString(1, nameMovie);
                searchMovieData.setString(2, hour);
                searchMovieData.setString(3, statistics);
                searchMovieData.setString(4, rating);
                searchMovieData.setString(5, genre);
                searchMovieData.setString(6, rowLetter);
                searchMovieData.setString(7, available);
                searchMovieData.setString(8, available);
                searchMovieData.setString(9, available);
                searchMovieData.setString(10, available);
                searchMovieData.setString(11, available);
                searchMovieData.setString(12, available);
                searchMovieData.setString(13, available);
                searchMovieData.setString(14, available);

                resultSaveData = searchMovieData.executeUpdate();
                if (resultSaveData > 0) {
                    JOptionPane.showMessageDialog(null, "La pelicula se creo con exito, porfavor " +
                            "espera a que se rellene la sala...");
                    int resultFill = fill3DMovie(cinema);
                    if (resultFill > 0) {
                        JOptionPane.showMessageDialog(null, "La pelicula se relleno con exito!!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Hubo un error al rellenar la " +
                                "pelicula");
                    }
                }
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
    }

    static int fillPremiumMovie() {

        String[] rowLetters = {"B", "C", "D", "E", "F", "G", "H", "I", "J"};
        String available = "D";
        int resultSaveData = 0;
        Connection connection = null;
        String movieData = "INSERT INTO PremiumMovie (RowLetter, C1, C2, C3, C4, C5, C6, C7, C8, C9, C10) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            connection = DataBaseData.connect();

            for (String rowLetter : rowLetters) {
                try (PreparedStatement searchMovieData = connection.prepareStatement(movieData)) {

                    searchMovieData.setString(1, rowLetter);
                    searchMovieData.setString(2, available);
                    searchMovieData.setString(3, available);
                    searchMovieData.setString(4, available);
                    searchMovieData.setString(5, available);
                    searchMovieData.setString(6, available);
                    searchMovieData.setString(7, available);
                    searchMovieData.setString(8, available);
                    searchMovieData.setString(9, available);
                    searchMovieData.setString(10, available);
                    searchMovieData.setString(11, available);
                    resultSaveData = searchMovieData.executeUpdate();
                }
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


    public static void createPremiumMovie(String nameMovie, String hour, String statistics, String rating, String genre) {

        String rowLetter = "A";
        String available = "D";
        int resultSaveData;
        Connection connection = null;
        String movieData = "INSERT INTO PremiumMovie (NameMovie, Hour, Statistics, Rating, Genre, RowLetter, C1, C2," +
                "C3, C4, C5, C6, C7, C8, C9, C10) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            connection = DataBaseData.connect();

            try(PreparedStatement searchMovieData = connection.prepareStatement(movieData)) {

                searchMovieData.setString(1, nameMovie);
                searchMovieData.setString(2, hour);
                searchMovieData.setString(3, statistics);
                searchMovieData.setString(4, rating);
                searchMovieData.setString(5, genre);
                searchMovieData.setString(6, rowLetter);
                searchMovieData.setString(7, available);
                searchMovieData.setString(8, available);
                searchMovieData.setString(9, available);
                searchMovieData.setString(10, available);
                searchMovieData.setString(11, available);
                searchMovieData.setString(12, available);
                searchMovieData.setString(13, available);
                searchMovieData.setString(14, available);
                searchMovieData.setString(15, available);
                searchMovieData.setString(16, available);

                resultSaveData = searchMovieData.executeUpdate();
                if (resultSaveData > 0) {
                    JOptionPane.showMessageDialog(null, "La pelicula se creo con exito, porfavor " +
                            "espera a que se rellene la sala...");
                    int resultFill = fillPremiumMovie();
                    if (resultFill > 0) {
                        JOptionPane.showMessageDialog(null, "La pelicula se relleno con exito!!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Hubo un error al rellenar la " +
                                "pelicula");
                    }
                }
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
    }

    public static String reserveSeat(String cinema, String column, String line) {

        String resultOperation = "";
        String occupied = "X";

        Connection connection;
        String movieData = "UPDATE "+cinema+" SET "+column+"=? WHERE RowLetter=?";

        try {

            connection = DataBaseData.connect();

            PreparedStatement checkSeat = connection.prepareStatement(movieData);
            checkSeat.setString(1, occupied);
            checkSeat.setString(2, line);
            int resultCheck = checkSeat.executeUpdate();

            if(resultCheck > 0) resultOperation = "Success";
            connection.close();

        }catch(SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

        return resultOperation;
    }

    public static String checkSeat(String cinema, String column, String line) {

        String resultOperation = "";
        Connection connection;
        String movieData = "SELECT "+column+" FROM "+cinema+" WHERE RowLetter=?";

        try {

            connection = DataBaseData.connect();

            PreparedStatement checkSeat = connection.prepareStatement(movieData);
            checkSeat.setString(1, line);
            ResultSet resultSearch = checkSeat.executeQuery();

            if(resultSearch.next()) resultOperation = resultSearch.getString(column);

            connection.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return resultOperation;
    }

    public static void buyTicket(String cinema, String column, String line) {

        String statusSeat = checkSeat(cinema, column, line);
        System.out.println(statusSeat);
        if(statusSeat.equals("D")) {
            int secure = JOptionPane.showConfirmDialog(null, """
                                                             El asiento esta disponible\040
                                                              Desea comparar el Asiento:\040""" +column+", "+line, "Venta Entradas",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (JOptionPane.OK_OPTION == secure) {
                String reserveSeat = reserveSeat(cinema, column, line);
                if (reserveSeat.equals("Success"))
                    JOptionPane.showMessageDialog(null, "La entrada se compro con Exito");
                else JOptionPane.showMessageDialog(null, "Hubo un error al comprar la entrada" +
                        "intentelo nuevamenete");
            } else {
                JOptionPane.showMessageDialog(null, "La compra se cancelo, " +
                        "muchas gracias por la Preferencia");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El asiento ya esta ocupado, lo sentimos");
        }
    }

    public static void deleteMovies(String movie) {

        Connection connection;
        String movieData = "TRUNCATE "+movie;

        try {

            connection = DataBaseData.connect();
            PreparedStatement delete = connection.prepareStatement(movieData);
            delete.executeUpdate();
            JOptionPane.showMessageDialog(null, "La pelicula se elimino correctamente");
            connection.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static String[] showInfoMovie(String cinema) {

        Connection connection;

        String[] data = new String[5];
        String movieData = "SELECT NameMovie, Hour, Statistics, Rating, Genre FROM "+cinema;

        try {

            connection = DataBaseData.connect();
            PreparedStatement searchInfo = connection.prepareStatement(movieData);
            ResultSet resultSearch = searchInfo.executeQuery();
            if(resultSearch.next()) {

                data[0] = resultSearch.getString("NameMovie");
                data[1] = resultSearch.getString("Hour");
                data[2] = resultSearch.getString("Statistics");
                data[3] = resultSearch.getString("Rating");
                data[4] = resultSearch.getString("Genre");
            }
            connection.close();
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return data;
    }

    public static void updateInfoMovie(String cinema, String newAttribute, String attribute) {

        String letter = "A";

        Connection connection;
        String movieData = "UPDATE "+cinema+" SET "+attribute+"=? WHERE RowLetter=?";

        try {

            connection = DataBaseData.connect();

            PreparedStatement checkSeat = connection.prepareStatement(movieData);
            checkSeat.setString(1, newAttribute);
            checkSeat.setString(2, letter);
            int resultCheck = checkSeat.executeUpdate();

            if(resultCheck > 0) JOptionPane.showMessageDialog(null, "Atributo actualizado" +
                    "de manera Exitosa!");
            connection.close();

        }catch(SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }
    }
}