import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);
    static Cine cine;

    public static void main(String[] args) {

        String menu = "\n1. Ver usuarios\n" + "2. Ver funciones(Crear Sala)\n" + "3. Estadisticas \n" + "4. Salir";
        String menu2 = "\n1. 2D\n" + "2. 3D\n" + "3. 3D PREMIUM\n" + "4. Salir";

        int opcion, opcion2;
        int filas, columnas, precio;
        double rating;

        do {
            System.out.println(menu);
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    break;
                case 2:
                    do {
                        System.out.println(menu2);
                        opcion2 = scanner.nextInt();
                        scanner = new Scanner(System.in);
                        switch (opcion2) {
                            case 1:
                                System.out.println("Ingrese el nombre de la pelicula a estrenar: ");
                                String pelicula = scanner.nextLine();
                                System.out.println("Ingrese el rating /10");
                                rating = scanner.nextDouble();


                                while (rating > 10) {
                                    System.out.println("VALORES FUERA DE RANGO, INGRESE OTRO VALOR: ");
                                    rating = scanner.nextDouble();
                                }

                                precio = 25;
                                filas = 2;
                                columnas = 2;
                                cine = new Cine(pelicula, filas, columnas, precio, rating);
                                cine.llenarSalaPorDefecto();
                                cine.imprimirSala();
                                break;
                            case 2:
                                System.out.println("Ingrese el nombre de la pelicula a estrenar: ");
                                pelicula = scanner.nextLine();
                                System.out.println("Ingrese el rating /10");
                                rating = scanner.nextDouble();

                                while (rating > 10) {
                                    System.out.println("VALORES FUERA DE RANGO, INGRESE OTRO VALOR: ");
                                    rating = scanner.nextDouble();
                                }

                                precio = 35;
                                filas = 3;
                                columnas = 3;
                                cine = new Cine(pelicula, filas, columnas, precio, rating);
                                cine.llenarSalaPorDefecto();
                                cine.imprimirSala();
                                break;
                            case 3:
                                System.out.println("Ingrese el nombre de la pelicula a estrenar: ");
                                pelicula = scanner.nextLine();
                                System.out.println("Ingrese el rating /10");
                                rating = scanner.nextDouble();

                                while (rating > 10) {
                                    System.out.println("VALORES FUERA DE RANGO, INGRESE OTRO VALOR: ");
                                    rating = scanner.nextDouble();
                                }

                                precio = 50;
                                filas = 5;
                                columnas = 11;
                                cine = new Cine(pelicula, filas, columnas, precio, rating);
                                cine.llenarSalaPorDefecto();
                                cine.imprimirSala();
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    } while (opcion2 != 4); {break;}
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 4);
    }

}
