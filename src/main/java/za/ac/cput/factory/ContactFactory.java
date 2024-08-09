package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.util.ContactHelper;

public class ContactFactory {

    public static Contact buildContact(String email, String mobileNumber){
        if(ContactHelper.validateEmail(email) || ContactHelper.checkNumber(mobileNumber)){
            return null;
        }

        return new Contact.Builder().setEmail(email).setMobileNumber(mobileNumber).build();
    }
}
