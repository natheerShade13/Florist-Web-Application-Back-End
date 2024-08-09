package za.ac.cput.util;

public class CartProductHelper {

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

    public static boolean isLessThanZero(int b){
        if(b <= 0){
            return true;
        }
        return false;
    }
}
