package za.ac.cput.utility;

import za.ac.cput.domain.Address;

import java.util.regex.Pattern;


public class ContactHelper {
    public static boolean isNumbersTenDigits(String n){
        if (String.valueOf(n).length()==10){
            return false;
        }
        return true;
    }
    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return true;
        }
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
    public static boolean isAddressNullOrEmpty(Address address) {
        if(address == null || address.toString().isEmpty()){
            return true;
        }
        return false;
    }
}
