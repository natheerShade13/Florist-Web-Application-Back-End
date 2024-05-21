package za.ac.cput.utility;

public class SupplierHelper {
    public static boolean isNullorEmpty(String s) {
        if (s == null || s.isEmpty())
            return true;
        return false;

    }

    public static boolean isValidEmail(String email) {
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        if (email.matches(regex)) return true;

        return false;
    }

    public static boolean isValidPhoneNumber(String number) {

        String regex = "(\\+?27|0)(\\d{9})";
        if (number.matches(regex))
            return true;
        return false;
    }

}
