import NetWork.DataBaseMovie;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        String nameMovie = "SpiderMan";
        String hour = "16:00";
        int statistics = 110;
        double rating = 8.9;
        String genre = "SuperHeroes";

        int successfully = DataBaseMovie.createMovie(nameMovie, hour, statistics, rating, genre);

        if(successfully >0){

            JOptionPane.showMessageDialog(null, "La pelicula se creo correctamente",
                    "2DMovie", JOptionPane.INFORMATION_MESSAGE);
        }else {

            JOptionPane.showMessageDialog(null, "Error al crear la pelicular\n"
                    + "Inténtelo nuevamente", "2DMovie", JOptionPane.ERROR_MESSAGE);

        }

        int success = DataBaseMovie.fillMovies2D();

        if(success >0){

            JOptionPane.showMessageDialog(null, "La pelicula se lleno correctamente",
                    "2DMovie", JOptionPane.INFORMATION_MESSAGE);
        }else{

            JOptionPane.showMessageDialog(null, "Error al llenar la pelicular\n"
                    + "Inténtelo nuevamente", "2DMovie", JOptionPane.ERROR_MESSAGE);
        }


    }
}
