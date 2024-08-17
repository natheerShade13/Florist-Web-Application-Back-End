package za.ac.cput.api;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerRegistrationTest {

    @Autowired
    private CustomerRegistration customerRegistration;

    private static Customer customer;

    @Test
    @Order(0)
    void setUp() {
        customer = CustomerFactory.buildCustomer("Jake", "Long"
                , "jake.long@gmail.com", "jakeLong", "0677784626"
                , LocalDate.of(2000, Month.JANUARY, 1));
    }

    @Test
    @Order(1)
    void registerCustomer() {
        Customer registerCustomer = customerRegistration.registerCustomer(customer);
        assertNotNull(registerCustomer);
        System.out.println(registerCustomer);
    }
}