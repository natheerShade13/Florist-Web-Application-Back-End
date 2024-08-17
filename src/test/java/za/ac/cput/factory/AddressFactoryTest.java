package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {

    private Customer customer;
    private Customer customerNull;
    private Address addressA;
    private Address addressB;

    @Test
    void buildAddress() {
        customer = CustomerFactory.buildCustomer("Jake", "Long"
                , "jake.long@gmail.com", "jakeLong", "0677784626"
                , LocalDate.of(2000, Month.JANUARY, 1));
        addressA = AddressFactory.buildAddress(1, "10", "Church street"
                , "Strandfontein", "7798", "Cape Town", customer);
        assertNotNull(addressA);
        System.out.println(addressA);
    }

    @Test
    void buildAddressFail() {
        customer = CustomerFactory.buildCustomer("Jake", "Long"
                , "jake.long@gmail.com", "jakeLong", "0677784626"
                , LocalDate.of(2000, Month.JANUARY, 1));
        addressB = AddressFactory.buildAddress(1, "10", "Church street"
                , "Strandfontein", "7798", "Cape Town", customerNull);
        assertNotNull(addressB);
        System.out.println(addressB);
    }

}