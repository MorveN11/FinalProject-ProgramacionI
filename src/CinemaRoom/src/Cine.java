public class Cine {

    private final String pelicula;
    private final int fila;
    private final int columna;
    private final Character[][] sala;
    private final int precio;
    private final int ticket;
    private final double rating;

    public Cine(String pelicula, int fila, int columna, int precio, double rating) {
        this.pelicula = pelicula;
        this.fila = fila;
        this.columna = columna;
        this.sala = new Character[fila + 1][columna + 1];
        this.ticket = 0;
        this.precio = precio;
        this.rating = rating;
    }

    public void llenarSalaPorDefecto() {
        for (int i = 0; i < sala.length; i++) {
            for (int j = 0; j < sala[0].length; j++) {
                if (i == 0 && j == 0) sala[i][j] = ' ';
                else if (i == 0) sala[i][j] = Character.forDigit(j, 10);
                else if (j == 0) sala[i][j] = Character.forDigit(i, 10);
                else sala[i][j] = 'D';
            }
        }
    }

    public void imprimirSala() {
        System.out.println("\nSala de cine: \n");
        for (Character[] asientos : sala) {
            System.out.print("Fila ");
            for (int j = 0; j < sala[0].length; j++) {
                System.out.print(asientos[j] + " ");
            }
            System.out.println("\n");
        }
        System.out.println("NOMBRE DE LA PELICULA: " + pelicula + "\n" + "ASIENTOS: " + (fila*columna) + "\n" + "RATING: " + rating +
                "\n" + "PRECIO ENTRADA: " + precio + "$");

        System.out.println("Total ingresos esperados : $ " + totalIngresosEsperado());
    }


    public int totalIngresosEsperado() {
        int totalIngresos, asientos;
        asientos = fila * columna;
        totalIngresos = (((int)((rating * 10) * asientos) / 100) * precio);
        return totalIngresos;
    }

    public float porcentajeVentas() {
        int cantidadAsientos = fila * columna;
        float porcentaje = (float) ticket / cantidadAsientos;
        return porcentaje * 100;
    }

    public void estadisticas() {

    }

}
