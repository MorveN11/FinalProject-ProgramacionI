package Utility;

public class Utilities {
    public static boolean verifyLarge(String password) {
        int count = 0;
        for (int i = 0; i <password.length();  i++) {
            count++;
        }
        return count > 7 && count < 16;
    }
}
