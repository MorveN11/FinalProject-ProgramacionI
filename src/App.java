import NetWork.DataBaseMovie;


public class App {
    public static void main(String[] args) throws InterruptedException {
        DataBaseMovie.updateInfoMovie("2DMovie1", "FastandFurios", "NameMovie");
        DataBaseMovie.updateInfoMovie("2DMovie2", "SpiderMan", "NameMovie");
    }
}
