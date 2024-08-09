package za.ac.cput.util;

import java.time.LocalDate;

public class CouponHelper {

    public static boolean validId(long a){
        if(a <= 0){
            return true;
        }
        return false;
    }

    public static boolean isNullOrEmpty(String a){
        if(a == null || a.isEmpty()){
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

    public static boolean isNull(LocalDate localDate){
        if (localDate == null)
            return true;
        return false;
    }

}
