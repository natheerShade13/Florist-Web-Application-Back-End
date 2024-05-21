package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.class)
class CustomerServiceTest {
    @Autowired
    private CustomerService customerService;
    private Address address;
    private Contact contact;
    private Customer customer;

    @BeforeEach
    void setUp() {
        address= AddressFactory.createAddress("11829","Tima Street","Mamelodi","Pretoria","0012","Guateng");
        contact = ContactFactory.createContact("FEREdimpe@gmail.com","0658523666","0128120167",address);
        customer = CustomerFactory.createCustomer("Keitumetse","Dimpe",contact);
    }
    @Test
    @Order(1)
    void setup(){
        assertNotNull(customer);
        System.out.println(customer);
    }
    @Test
    @Order(2)
    void create() {
        Customer created = customerService.create(customer);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(3)
    void read() {
        Customer read = customerService.read(customer.getId());
        System.out.println(read);
    }

    @Test
    @Order(4)
    void update() {
        Customer newCustomer = new Customer.Builder().copy(customer).setFirstName("Fereshteh Keitumetse").build();
        Customer updated = customerService.update(newCustomer);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(5)
    void getAll() {
        customerService.getAll();
    }
}