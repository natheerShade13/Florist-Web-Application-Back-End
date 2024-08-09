package za.ac.cput.util;

import java.util.UUID;

public class CartHelper {

    public static boolean validId(long a){
        if(a <= 0){
            return true;
        }
        return false;
    }

    public static long generateUniqueID() {
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }

}
