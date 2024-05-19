package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;
import za.ac.cput.utility.AddressHelper;
import za.ac.cput.utility.CustomerHelper;

public class CustomerFactory {
    public static Customer createCustomer(long customerId, String firstName, String lastName, Contact contact){
        if(customerId<0|| CustomerHelper.isStringNullOrEmpty(firstName) ||
                CustomerHelper.isStringNullOrEmpty(lastName)||
                CustomerHelper.isContactNullOrEmpty(contact)){
            return null;}

        return new Customer.Builder()
                .setId(customerId)
                .setFirstName(firstName)
                .setLastname(lastName)
                .setContact(contact).build();
    }
    public static Customer createCustomer( String firstName, String lastName, Contact contact){
        if( CustomerHelper.isStringNullOrEmpty(firstName) ||
                CustomerHelper.isStringNullOrEmpty(lastName)||
                CustomerHelper.isContactNullOrEmpty(contact)){
            return null;}
        long customerId= CustomerHelper.generateUniqueID();
        return new Customer.Builder()
                .setId(customerId)
                .setFirstName(firstName)
                .setLastname(lastName)
                .setContact(contact).build();
    }
}
