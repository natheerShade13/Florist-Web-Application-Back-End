package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;
import za.ac.cput.util.CustomerHelper;

import java.time.LocalDate;

//Create factory for auto generated Id;
//Consider values that are allowed to be null;

public class CustomerFactory {

    public static Customer buildCustomer(long customerId, String firstName, String lastName, String email
            , String password, String mobileNumber, LocalDate dateOfBirth){

        if(CustomerHelper.validId(customerId) || CustomerHelper.isNullOrEmpty(firstName) ||
                CustomerHelper.isNullOrEmpty(lastName) || CustomerHelper.validateEmail(email)
                || CustomerHelper.isNullOrEmpty(password) || CustomerHelper.checkNumber(mobileNumber)
                || CustomerHelper.isNull(dateOfBirth)){
            return null;
        }

        return new Customer.Builder().setCustomerId(customerId).setFirstName(firstName).setLastName(lastName)
                .setEmail(email).setPassword(password).setMobileNumber(mobileNumber).setDateOfBirth(dateOfBirth)
                .build();
    }
}
