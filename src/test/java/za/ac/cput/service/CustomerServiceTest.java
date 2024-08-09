package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.CustomerFactory;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    private static Customer customer;

    @Test
    @Order(0)
    void setup(){
        customer = CustomerFactory.buildCustomer(1, "Jake", "Long"
                , "jake.long@gmail.com", "jakeLong", "0677784626"
                , LocalDate.of(2000, Month.JANUARY, 1));
    }

    @Test
    @Order(1)
    void create() {
        Customer createCustomer = customerService.create(customer);
        assertNotNull(createCustomer);
        System.out.println(createCustomer);
    }

    @Test
    @Order(2)
    void read() {
        Customer findCustomer = customerService.read(customer.getCustomerId());
        assertNotNull(findCustomer);
        System.out.println(findCustomer);
    }

    @Test
    @Order(3)
    void update() {
        Customer newCustomer = new Customer.Builder().copy(customer).setFirstName("Madara").setLastName("Uchiha")
                .setPassword("madaraUchiha").build();
        assertNotNull(newCustomer);
        Customer updateCustomer = customerService.update(newCustomer);
        System.out.println(updateCustomer);
    }

    @Test
    @Order(5)
    @Disabled
    void delete() {
        boolean deleteCustomer = customerService.delete(customer.getCustomerId());
        assertTrue(deleteCustomer);
        System.out.println(deleteCustomer);
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(customerService.getAll());
    }
}