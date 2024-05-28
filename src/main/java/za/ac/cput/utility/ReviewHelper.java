package za.ac.cput.utility;

import java.util.Date;
import java.util.UUID;

public class ReviewHelper {
    public static boolean isNullOrEmpty(String a){
        if (a == null || a.isEmpty()) {
            return true;
        }
        return false;
    }

    public static long generateUniqueID() {
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;

    }
}
