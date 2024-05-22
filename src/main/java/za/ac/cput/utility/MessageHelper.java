package za.ac.cput.utility;

import java.util.Date;
import java.util.UUID;

public class MessageHelper {
    public static boolean isNullOrEmpty(String a){
        if (a == null || a.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isNull(Date date){
        if (date == null)
            return true;
        return false;
    }

    public static boolean isNegative(int b){
        if(b < 0)
            return true;
        return false;
    }

    public static boolean isNegative(double a){
        if(a < 0)
            return true;
        return false;
    }


    public static String generateID(){
        return UUID.randomUUID().toString();
    }

    public static long generateUniqueID() {
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;

    }
}
