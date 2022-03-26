import NetWork.DataBaseData;
import NetWork.DataBaseMovie;
import Utility.Utilities;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws InterruptedException {
        String[] data = DataBaseMovie.showInfoMovie("2DMovie1");
        System.out.println(Arrays.toString(data));
    }
}
