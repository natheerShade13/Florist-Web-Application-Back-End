package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {

    private Customer customerA;
    private Customer customerB;

    @Test
    void buildCustomer() {
        customerA = CustomerFactory.buildCustomer(1, "Jake", "Long"
                , "jake.long@gmail.com", "jakeLong", "0677784626"
                , LocalDate.of(2000, Month.JANUARY, 1));
        assertNotNull(customerA);
        System.out.println(customerA);
    }

    @Test
    void buildCustomerFail() {
        customerB = CustomerFactory.buildCustomer(1, "", "Long"
                , "jake.long@gmail.com", "jakeLong", "0677784626"
                , LocalDate.of(2000, Month.JANUARY, 1));
        assertNotNull(customerB);
        System.out.println(customerB);
    }

}