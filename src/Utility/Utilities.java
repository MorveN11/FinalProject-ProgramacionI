package Utility;


public class Utilities {

public static String name;
public static String lastName;
public static String email;
public static String cellPhone;
public static String userName;

    public static boolean verifyLarge(String password) {
        int count = 0;
        for (int i = 0; i <password.length();  i++) {
            count++;
        }
        return count > 7 && count < 16;
    }
}
