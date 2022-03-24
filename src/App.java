import NetWork.DataBaseMovie;

public class App {
    public static void main(String[] args) {
        DataBaseMovie.create2DMovie(1, "SpiderMan", "12:00", 400, 8.5,
                "SuperHeroes");
        DataBaseMovie.create2DMovie(2, "Avengers", "13:00", 500, 7.8,
                "SuperHeroes");
        DataBaseMovie.create3DMovie(1, "El Padrino", "14:00", 350, 6.9,
                "Drama");
        DataBaseMovie.create3DMovie(2, "Bob Esponja", "15:00", 450, 7.2,
                "Infantile");
        DataBaseMovie.createPremiumMovie("Interstellar", "16:00", 600, 8.4,
                "Ficcion");
    }
}
