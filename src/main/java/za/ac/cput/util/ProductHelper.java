package za.ac.cput.util;

import java.util.UUID;
import java.util.regex.Pattern;

public class ProductHelper {

    public static boolean isNullOrEmpty(String a){
        if(a == null || a.isEmpty()){
            return true;
        }
        return false;
    }

    public static boolean validId(long a){
        if(a <= 0){
            return true;
        }
        return false;
    }

    public static boolean isNegative(double b){
        if(b < 0){
            return true;
        }
        return false;
    }

    public static boolean isNegative(int b){
        if(b < 0){
            return true;
        }
        return false;
    }

    public static boolean isValidImageUrl(String url) {
        if (url == null || url.isBlank()) {
            return false;
        }

        String regex = "^(http|https)://.*";
        return Pattern.matches(regex, url);
    }

    public static long generateUniqueID() {
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }
}
