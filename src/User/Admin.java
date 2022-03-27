package User;

import NetWork.DataBaseChallenges;
import NetWork.DataBaseData;
import NetWork.DataBaseMovie;
import Utility.Utilities;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

import static Utility.Utilities.verifyInt;
import static javax.swing.JOptionPane.*;

public class Admin {
    public static boolean code = true;
    public static Scanner scanner = new Scanner(System.in);
    public static String[][] table;
    public static String txtNameMovie = "Cual sera el nuevo nombre de la pelicula?";
    public static String txtHour = "Cual sera la nueva hora de la pelicula?";
    public static String txtStatistics = "Que nueva estadistica tendra la pelicula?";
    public static String txtRating = "Que nuevo rating tendra la pelicula?";
    public static String txtGenre = "De que nuevo genero sera la pelicula?";
    public static String menu = """
            \nElija la operacion que desea realizar\s
             1. Mostrar los usuarios de la base de datos
             2. Eliminar a un usuario de la base de datos
             3. Realizar mantenimiento de la base de datos
             4. Actualizar una pelicula
             5. Leer una pelicula
             6. Crear pelicula
             7. Eliminar pelicula
             8. Lanzar un nuevo reto diario
             9. Cambiar retos diarios
             10. Leer retos diarios
             11. Eliminar un reto diario
             12. Lanzar un nuevo reto semanal
             13. Cambiar retos semanales
             14. Leer retos semanales
             15. Eliminar un reto semanal
             16. Salir de la terminal
            """;
    public static String menuCreateMovies = """
                \n¿En que sala desea crear la pelicula?\s
                1. 2DMovie1
                2. 2DMovie2
                3. 3DMovie1
                4. 3DMovie2
                5. PremiumMovie
                """;
    public static String menuDeleteMovies = """
                \nQue sala desea eliminar?\s
                1. 2DMovie1
                2. 2DMovie2
                3. 3DMovie1
                4. 3DMovie2
                5. PremiumMovie
                """;
    public static String menuReadMovies = """
                \nQue sala desea leer?\s
                 1. 2DMovie1
                 2. 2DMovie2
                 3. 3DMovie1
                 4. 3DMovie2
                 5. PremiumMovie
                 """;
    public static String menuUpdateMovies = """
                \nQue sala desea actualizar?\s
                 1. 2DMovie1
                 2. 2DMovie2
                 3. 3DMovie1
                 4. 3DMovie2
                 5. PremiumMovie
                 """;
    public static String menuAttributesMovies = """
                \nQue atributo desea actualizar?\s
                 1. Nombre de la pelicula
                 2. Hora de la pelicula
                 3. Stadisticas de la pelicula
                 4. Rating de la pelicula
                 5. Genero de la pelicula
                 """;

    public static void showUsers() {
        int count = 1;
        for (String[] line : Admin.table) {
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

    public static void deleteUser(int fUser) {
        fUser -=1;
        String user = Admin.table[fUser][5];
        int secure = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar al " +
                "usuario "+user, "Eliminar Usuario", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (OK_OPTION == secure) {
            Connection connection;
            try {
                connection = DataBaseData.connect();
                String searchUser = "DELETE FROM Data WHERE UserName=?";
                PreparedStatement statement = connection.prepareStatement(searchUser);
                statement.setString(1,user);
                statement.executeUpdate();
                System.out.println("El usuario: "+user+" se elimino correctamente");
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("No se pudo eliminar al usuario");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se elimino el usuario");
        }
    }

    public static void code() {
        DataBaseData.searchDataUsers();
        Admin.table = DataBaseData.table;
        while(code) {
            int option1 = verifyInt(menu);
            switch (option1) {
                case 1 -> showUsers();
                case 2 -> {
                    boolean condition;
                    int line;
                    do {
                        line = Utilities.verifyInt("Eliga la fila del usuario que desea eliminar");
                        condition = Utilities.verifyTableData(line);
                    } while(!condition);
                    Admin.deleteUser(line);
                }
                case 3 -> DataBaseData.maintenance();
                case 4 -> {
                    boolean condition = true;
                    while (condition) {
                        int option = Utilities.verifyInt(menuUpdateMovies);
                        switch (option) {
                            case 1 -> {
                                boolean attrCondition = true;
                                while (attrCondition) {
                                    int attrOption = Utilities.verifyInt(menuAttributesMovies);
                                    switch (attrOption) {
                                        case 1 -> {
                                            System.out.println(txtNameMovie);
                                            DataBaseMovie.updateInfoMovie("2DMovie1", scanner.next(), "NameMovie");
                                            attrCondition = false;
                                        }
                                        case 2 -> {
                                            System.out.println(txtHour);
                                            DataBaseMovie.updateInfoMovie("2DMovie1", scanner.next(), "Hour");
                                            attrCondition = false;
                                        }
                                        case 3 -> {
                                            System.out.println(txtStatistics);
                                            DataBaseMovie.updateInfoMovie("2DMovie1", scanner.next(), "Statistics");
                                            attrCondition = false;
                                        }
                                        case 4 -> {
                                            System.out.println(txtRating);
                                            DataBaseMovie.updateInfoMovie("2DMovie1", scanner.next(), "Rating");
                                            attrCondition = false;
                                        }
                                        case 5 -> {
                                            System.out.println(txtGenre);
                                            DataBaseMovie.updateInfoMovie("2DMovie1", scanner.next(), "Genre");
                                            attrCondition = false;
                                        }
                                        default -> System.out.println("Ingrese un numero de Atributo valido");
                                    }
                                }
                                condition = false;
                            }
                            case 2 -> {
                                boolean attrCondition = true;
                                while (attrCondition) {
                                    int attrOption = Utilities.verifyInt(menuAttributesMovies);
                                    switch (attrOption) {
                                        case 1 -> {
                                            System.out.println(txtNameMovie);
                                            DataBaseMovie.updateInfoMovie("2DMovie2", scanner.next(), "NameMovie");
                                            attrCondition = false;
                                        }
                                        case 2 -> {
                                            System.out.println(txtHour);
                                            DataBaseMovie.updateInfoMovie("2DMovie2", scanner.next(), "Hour");
                                            attrCondition = false;
                                        }
                                        case 3 -> {
                                            System.out.println(txtStatistics);
                                            DataBaseMovie.updateInfoMovie("2DMovie2", scanner.next(), "Statistics");
                                            attrCondition = false;
                                        }
                                        case 4 -> {
                                            System.out.println(txtRating);
                                            DataBaseMovie.updateInfoMovie("2DMovie2", scanner.next(), "Rating");
                                            attrCondition = false;
                                        }
                                        case 5 -> {
                                            System.out.println(txtGenre);
                                            DataBaseMovie.updateInfoMovie("2DMovie2", scanner.next(), "Genre");
                                            attrCondition = false;
                                        }
                                        default -> System.out.println("Ingrese un numero de Atributo valido");
                                    }
                                }
                                condition = false;
                            }
                            case 3 -> {
                                boolean attrCondition = true;
                                while (attrCondition) {
                                    int attrOption = Utilities.verifyInt(menuAttributesMovies);
                                    switch (attrOption) {
                                        case 1 -> {
                                            System.out.println(txtNameMovie);
                                            DataBaseMovie.updateInfoMovie("3DMovie1", scanner.next(), "NameMovie");
                                            attrCondition = false;
                                        }
                                        case 2 -> {
                                            System.out.println(txtHour);
                                            DataBaseMovie.updateInfoMovie("3DMovie1", scanner.next(), "Hour");
                                            attrCondition = false;
                                        }
                                        case 3 -> {
                                            System.out.println(txtStatistics);
                                            DataBaseMovie.updateInfoMovie("3DMovie1", scanner.next(), "Statistics");
                                            attrCondition = false;
                                        }
                                        case 4 -> {
                                            System.out.println(txtRating);
                                            DataBaseMovie.updateInfoMovie("3DMovie1", scanner.next(), "Rating");
                                            attrCondition = false;
                                        }
                                        case 5 -> {
                                            System.out.println(txtGenre);
                                            DataBaseMovie.updateInfoMovie("3DMovie1", scanner.next(), "Genre");
                                            attrCondition = false;
                                        }
                                        default -> System.out.println("Ingrese un numero de Atributo valido");
                                    }
                                }
                                condition = false;
                            }
                            case 4 -> {
                                boolean attrCondition = true;
                                while (attrCondition) {
                                    int attrOption = Utilities.verifyInt(menuAttributesMovies);
                                    switch (attrOption) {
                                        case 1 -> {
                                            System.out.println(txtNameMovie);
                                            DataBaseMovie.updateInfoMovie("3DMovie2", scanner.next(), "NameMovie");
                                            attrCondition = false;
                                        }
                                        case 2 -> {
                                            System.out.println(txtHour);
                                            DataBaseMovie.updateInfoMovie("3DMovie2", scanner.next(), "Hour");
                                            attrCondition = false;
                                        }
                                        case 3 -> {
                                            System.out.println(txtStatistics);
                                            DataBaseMovie.updateInfoMovie("3DMovie2", scanner.next(), "Statistics");
                                            attrCondition = false;
                                        }
                                        case 4 -> {
                                            System.out.println(txtRating);
                                            DataBaseMovie.updateInfoMovie("3DMovie2", scanner.next(), "Rating");
                                            attrCondition = false;
                                        }
                                        case 5 -> {
                                            System.out.println(txtGenre);
                                            DataBaseMovie.updateInfoMovie("3DMovie2", scanner.next(), "Genre");
                                            attrCondition = false;
                                        }
                                        default -> System.out.println("Ingrese un numero de Atributo valido");
                                    }
                                }
                                condition = false;
                            }
                            case 5 -> {
                                boolean attrCondition = true;
                                while (attrCondition) {
                                    int attrOption = Utilities.verifyInt(menuAttributesMovies);
                                    switch (attrOption) {
                                        case 1 -> {
                                            System.out.println(txtNameMovie);
                                            DataBaseMovie.updateInfoMovie("PremiumMovie", scanner.next(), "NameMovie");
                                            attrCondition = false;
                                        }
                                        case 2 -> {
                                            System.out.println(txtHour);
                                            DataBaseMovie.updateInfoMovie("PremiumMovie", scanner.next(), "Hour");
                                            attrCondition = false;
                                        }
                                        case 3 -> {
                                            System.out.println(txtStatistics);
                                            DataBaseMovie.updateInfoMovie("PremiumMovie", scanner.next(), "Statistics");
                                            attrCondition = false;
                                        }
                                        case 4 -> {
                                            System.out.println(txtRating);
                                            DataBaseMovie.updateInfoMovie("PremiumMovie", scanner.next(), "Rating");
                                            attrCondition = false;
                                        }
                                        case 5 -> {
                                            System.out.println(txtGenre);
                                            DataBaseMovie.updateInfoMovie("PremiumMovie", scanner.next(), "Genre");
                                            attrCondition = false;
                                        }
                                        default -> System.out.println("Ingrese un numero de Atributo valido");
                                    }
                                }
                                condition = false;
                            }
                            default -> System.out.println("Ingrese un numero de sala valida");
                        }
                    }
                }
                case 5 -> {
                    boolean condition = true;
                    while (condition) {
                        int option = Utilities.verifyInt(menuReadMovies);
                        switch (option) {
                            case 1 -> {
                                String[] data = DataBaseMovie.showInfoMovie("2DMovie1");
                                System.out.println(Arrays.toString(data));
                                condition = false;
                            }
                            case 2 -> {
                                String[] data = DataBaseMovie.showInfoMovie("2DMovie2");
                                System.out.println(Arrays.toString(data));
                                condition = false;
                            }
                            case 3 -> {
                                String[] data = DataBaseMovie.showInfoMovie("3DMovie1");
                                System.out.println(Arrays.toString(data));
                                condition = false;
                            }
                            case 4 -> {
                                String[] data = DataBaseMovie.showInfoMovie("3DMovie2");
                                System.out.println(Arrays.toString(data));
                                condition = false;
                            }
                            case 5 -> {
                                String[] data = DataBaseMovie.showInfoMovie("PremiumMovie");
                                System.out.println(Arrays.toString(data));
                                condition = false;
                            }
                            default -> System.out.println("Ingrese una sala valida");
                        }
                    }
                }
                case 6 -> {
                    boolean condition = true;
                    while (condition) {
                        int option = Utilities.verifyInt(menuCreateMovies);
                        switch (option) {
                            case 1 -> {
                                String[] data = Utilities.auxCreateMovie();
                                DataBaseMovie.create2DMovie(1, data[0], data[1], data[2], data[3], data[4]);
                                condition = false;
                            }
                            case 2 -> {
                                String[] data = Utilities.auxCreateMovie();
                                DataBaseMovie.create2DMovie(2, data[0], data[1], data[2], data[3], data[4]);
                                condition = false;
                            }
                            case 3 -> {
                                String[] data = Utilities.auxCreateMovie();
                                DataBaseMovie.create3DMovie(1, data[0], data[1], data[2], data[3], data[4]);
                                condition = false;
                            }
                            case 4 -> {
                                String[] data = Utilities.auxCreateMovie();
                                DataBaseMovie.create3DMovie(2, data[0], data[1], data[2], data[3], data[4]);
                                condition = false;
                            }
                            case 5 -> {
                                String[] data = Utilities.auxCreateMovie();
                                DataBaseMovie.createPremiumMovie(data[0], data[1], data[2], data[3], data[4]);
                                condition = false;
                            }
                            default -> System.out.println("Ingrese un valor valido");
                        }
                    }
                }
                case 7 -> {
                    boolean condition = true;
                    while (condition) {
                        int option = verifyInt(menuDeleteMovies);
                        switch (option) {
                            case 1 -> {
                                DataBaseMovie.deleteMovies("2DMovie1");
                                condition = false;
                            }
                            case 2 -> {
                                DataBaseMovie.deleteMovies("2DMovie2");
                                condition = false;
                            }
                            case 3 -> {
                                DataBaseMovie.deleteMovies("3DMovie1");
                                condition = false;
                            }
                            case 4 -> {
                                DataBaseMovie.deleteMovies("3DMovie2");
                                condition = false;
                            }
                            case 5 -> {
                                DataBaseMovie.deleteMovies("PremiumMovie");
                                condition = false;
                            }
                            default -> System.out.println("Ingrese un valor valido");
                        }
                    }
                }
                case 8 -> {
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
                case 9 -> {
                    int secure = JOptionPane.showConfirmDialog(null, "Desea reiniciar las tareas " +
                                    "diarias de los usuarios", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (OK_OPTION == secure) {
                        DataBaseChallenges.updateDailyTasks();
                        JOptionPane.showMessageDialog(null, "Los retos diarios han sido cambiados",
                                null, INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se reinciarion los retos diarios de " +
                                "los usuarios");
                    }
                }
                case 10 -> DataBaseChallenges.showDailyTasks();
                case 11 -> {
                    boolean condition;
                    int line;
                    do {
                        line = Utilities.verifyInt("Eliga la fila de reto diario dese Eliminar?");
                        condition = Utilities.verifyDBDailyChallenges(line);
                    } while(!condition);
                    DataBaseChallenges.deleteDailyTasks(line);
                }
                case 12 -> {
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
                case 13 -> {
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
                case 14 -> DataBaseChallenges.showWeeklyTasks();
                case 15 -> {
                    boolean condition;
                    int line;
                    do {
                        line = Utilities.verifyInt("Eliga la fila de reto semanal dese Eliminar?");
                        condition = Utilities.verifyDBWeeklyChallenges(line);
                    } while(!condition);
                    DataBaseChallenges.deleteWeeklyTasks(line);
                }
                case 16 -> {
                    System.out.println("Muchas gracias sudo!");
                    code = false;
                }
                default -> System.out.println("Ingrese un valor valido");
            }
        }
    }
}
