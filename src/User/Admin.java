package User;

import NetWork.DataBaseData;
import NetWork.DataBaseMovie;
import Utility.Utilities;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static Utility.Utilities.verifyInt;

public class Admin {
    public static boolean code = true;
    public static String[][] table;
    public static String menu = """
            \nElija la operacion que desea realizar\s
             1. Mostrar a los usuarios
             2. Eliminar a un usuario
             3. Realizar mantenimiento de servidores
             4. Actualizar una pelicula
             5. Leer una pelicula
             6. Crear pelicula
             7. Eliminar pelicula
             8. Salir de la terminal
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
                \n¿Que pelicula desea eliminar?\s
                1. 2DMovie1
                2. 2DMovie2
                3. 3DMovie1
                4. 3DMovie2
                5. PremiumMovie
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

        if (JOptionPane.OK_OPTION == secure) {
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
                case 4 -> System.out.println("Pelicula actulizada");
                case 5 -> System.out.println("Pelicula leida");
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
                    System.out.println("Muchas gracias sudo!");
                    code = false;
                }
                default -> System.out.println("Ingrese un valor valido");
            }
        }
    }
}
