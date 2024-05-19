package za.ac.cput.utility;

import java.util.UUID;

public class AddressHelper {
    public static boolean isStringNullOrEmpty(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        return false;
    }
    public static long generateUniqueID() {
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;

    }
}
