package NetWork;

import javax.swing.*;
import java.sql.*;

public class DataBaseMovie {


    public static int createMovie(String nameMovie, String hour, int statistics, double rating, String genre) {
        String stringStatistics = String.valueOf(statistics);
        String stringRating = String.valueOf(rating);

        int resultSaveData = 0;
        Connection connection = null;
        String movieData = "INSERT INTO 2DMovie (NameMovie, Hour, Statistics, Rating, Genre, RowLetter, C1, C2," +
                "C3, C4, C5, C6) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String rowLetter = "A";
        String available = "D";

        try {

            connection = DataBaseData.connect();

            try(PreparedStatement searchMovieData = connection.prepareStatement(movieData)) {

                searchMovieData.setString(1, nameMovie);
                searchMovieData.setString(2, hour);
                searchMovieData.setString(3, stringStatistics);
                searchMovieData.setString(4, stringRating);
                searchMovieData.setString(5, genre);
                searchMovieData.setString(6, rowLetter);
                searchMovieData.setString(7, available);
                searchMovieData.setString(8, available);
                searchMovieData.setString(9, available);
                searchMovieData.setString(10, available);
                searchMovieData.setString(11, available);
                searchMovieData.setString(12, available);

                resultSaveData = searchMovieData.executeUpdate();
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

    public static int fillMovies2D() {
        int resultSaveData = 0;
        Connection connection = null;
        String movieData = "INSERT INTO 2DMovie (RowLetter, C1, C2, C3, C4, C5, C6) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        String[] rowLetters = {"B", "C", "D", "E", "F", "G", "H"};
        String available = "D";
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

}
