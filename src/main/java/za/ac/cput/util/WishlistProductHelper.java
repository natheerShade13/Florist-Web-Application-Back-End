package za.ac.cput.util;

public class WishlistProductHelper {
    public static boolean validId(long a){
        if(a <= 0){
            return true;
        }
        return false;
    }
}
