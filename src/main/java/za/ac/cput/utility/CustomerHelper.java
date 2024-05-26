package za.ac.cput.utility;

import java.util.UUID;

public class CustomerHelper {
    public static class CartHelper {
        public static long generateUniqueID() {
            return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        }

        public static boolean isValidId(long value) {
            return value > 0;
        }

        public static boolean isValidQuantity(int quantity) {
            return quantity > 0;
        }

        public static boolean isValidPrice(double price) {
            return price >= 0;
        }
    }
}
