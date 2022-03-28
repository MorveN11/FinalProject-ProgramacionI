import Panels.HomeScreen;
import Utility.Utilities;


public class App {
    public static void main(String[] args) {
        Utilities.loadCine();
        HomeScreen show = new HomeScreen();
        show.setVisible(true);
    }
}
