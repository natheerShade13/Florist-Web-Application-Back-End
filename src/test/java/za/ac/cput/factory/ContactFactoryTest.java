package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;

import static org.junit.jupiter.api.Assertions.*;

class ContactFactoryTest {
    private Address address;
    private Contact contact1;
    private Contact contact2;
    private Contact contact3;
    @BeforeEach
    void setUp() {
        address = AddressFactory.createAddress("67", "Lower Street", " Mowbray", "Cape Town","7700", "Western Cape");
        contact1 = ContactFactory.createContact("keitudimpe@example.com", "0987654321", "0123456789", address);
        contact2 = ContactFactory.createContact("keitudimpeexample.com", "0987654321", "0123456789", address);
        contact3=contact1;
    }
    @Test
    void checkIfNotNull() {
        assertNotNull(contact1);
        System.out.println(contact1);
    }
    @Test
    void checkIfNull() {
        assertNull(contact2);
        System.out.println(contact2);
    }
    @Test
    void equalityTest(){
        assertNotEquals(contact1,contact2);
        System.out.println("NOT EQUAL");
    }
    @Test
    void identityTest(){
        assertSame(contact1, contact3);
        System.out.println("IDENTICAL");
    }
}