package Utility;


import NetWork.DataBaseChallenges;
import User.Admin;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilities {

    public static String[] abc = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
                                    "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    public static boolean verifyLarge(String password) {
        int count = 0;
        for (int i = 0; i <password.length();  i++) {
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
            } catch (InputMismatchException ime){
                System.out.println("Aviso! Solo numeros enteros son permitidos");
                scanner.next();
                condition = false;
            }
        } while (!condition);
        return number;
    }

    public static double verifyDouble(String text){
        Scanner scanner = new Scanner(System.in);
        boolean condition = false;
        double number = 0;
        do {
            System.out.println(text);
            try {
                number = scanner.nextDouble();
                condition = true;
            } catch(InputMismatchException ime) {
                System.out.println("Aviso! Solo numeros decimales son permitidos");
                scanner.next();
            }
        } while(!condition);
        return number;
    }

    public static boolean verifyTableData(int numberLine) {
        if(numberLine > 0 && numberLine <= Admin.table.length) {
            return true;
        } else {
            System.out.println("Valor de fila invalido");
            return false;
        }
    }

    public static String[] auxCreateMovie() {
        String[] data = new String[5];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elija el nombre de la pelicula");
        data[0] = scanner.next();
        System.out.println("Ingrese la hora de la pelicula");
        data[1] = scanner.next();
        data[2] = String.valueOf(verifyInt("Ingrese las estadisticas de la pelicula"));
        data[3] = String.valueOf(verifyDouble("Ingrese el rating de la pelicula"));
        System.out.println("Ingrese el genero de la pelcula");
        data[4] = scanner.next();
        return data;
    }

    public static String confirmReset(String text){
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
        if (number > 0 && number <= DataBaseChallenges.indexDailyTasks()){
            return true;
        } else {
            System.out.println("Valor de fila invalido");
            return false;
        }
    }

    public static boolean verifyDBWeeklyChallenges(int number) {
        if (number > 0 && number <= DataBaseChallenges.indexWeeklyTasks()){
            return true;
        } else {
            System.out.println("Valor de fila invalido");
            return false;
        }
    }
}
