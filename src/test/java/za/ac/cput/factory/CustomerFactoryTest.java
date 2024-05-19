package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {
    private Contact contact;
    private Address address;
    private Customer customer1;
    private Customer customer2;
    private Customer customer3;

    @BeforeEach
    void setUp() {
        address = AddressFactory.createAddress("67", "Lower Street", " Mowbray", "Cape Town","7700", "Western Cape");
        contact = ContactFactory.createContact("keitudimpe@example.com", "0987654321", "0123456789", address);
        customer1 = CustomerFactory.createCustomer("John", "Doe", contact);
        customer2 = CustomerFactory.createCustomer( "leago", "", contact);
        customer3=customer1;
    }
    @Test
    void checkIfNotNull() {
        assertNotNull(customer1);
        System.out.println(customer1);
    }
    @Test
    void checkIfNull() {
        assertNull(customer2);
        System.out.println(customer2);
    }
    @Test
    void equalityTest(){
        assertNotEquals(customer1,customer2);
        System.out.println("NOT EQUAL");
    }
    @Test
    void identityTest(){
        assertSame(customer1, customer3);
        System.out.println("IDENTICAL");
    }
}