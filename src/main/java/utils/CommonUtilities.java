package utils;

import java.util.Date;

public class CommonUtilities {

    public static String generateEmailAddress() {
        return new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "") + "@gmail.com";
    }

}
