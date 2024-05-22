package za.ac.cput.utility;

import java.util.UUID;
import java.util.regex.Pattern;

public class ProductHelper {

    public static boolean isNullorEmpty(String s) {
        if (s == null || s.isEmpty())
            return true;
        return false;

    }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static boolean isValidPrice(double price) {
        if (price > 0)
            return true;
        return false;
    }

    public static boolean isValidImageUrl(String url) {
        if (url == null || url.isBlank()) {
            return false;
        }

        String regex = "^(http|https)://.*";
        return Pattern.matches(regex, url);
    }
}
