package User;

import NetWork.DataBaseData;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Admin {
    static boolean code = true;
    static Scanner scanner = new Scanner(System.in);
    public static String menu = """
            Elija la operacion que desea realizar\s
             1.Mostrar a los usuarios
             2.Eliminar a un usuario
             3.Salir de la terminal""";

    public static void showUsers() {
        DataBaseData.searchDataUsers();
        for (String[] line : DataBaseData.table) {
            System.out.print("[");
            for (int i = 0; i < line.length; i++) {
                System.out.print(line[i]);
                if (i != line.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    public static void deleteUser(int fUser) {
        String user = DataBaseData.table[fUser][5];
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
        while(code) {
            System.out.println(menu);
            int option1 = scanner.nextInt();
            switch (option1) {
                case 1 -> showUsers();
                case 2 -> {
                    showUsers();
                    System.out.println("Eliga la fila del usuario que desea eliminar");
                    scanner = new Scanner(System.in);
                    int line = scanner.nextInt();
                    Admin.deleteUser(line);
                    showUsers();
                }
                case 3 -> {
                    System.out.println("Muchas gracias sudo!");
                    code = false;
                }
                default -> System.out.println("Ingrese un valor valido");
            }
        }
    }
}
