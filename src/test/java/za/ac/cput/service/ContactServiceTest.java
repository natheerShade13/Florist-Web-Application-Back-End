package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Contact;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.ContactFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.class)
class ContactServiceTest {
    @Autowired
    private ContactService contactService;
    private static Contact contact;
    private Address address;

    @BeforeEach
    void setUp() {
        address = AddressFactory.createAddress( "67", "Lower Street", " Mowbray", "Cape Town","7700", "Western Cape");
        contact = ContactFactory.createContact("keitudimpe@example.com", "0987654321", "0123456789", address);
    }
    @Test
    @Order(1)
    void setup() {
        assertNotNull(contact);
        System.out.println(contact);

    }

    @Test
    @Order(2)
    void create() {
        Contact created = contactService.create(contact);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(3)
    void read() {
        Contact read=contactService.read(contact.getEmail());
        System.out.println(read);
    }

    @Test
    @Order(4)
    void update() {
        Contact newContact = new Contact.Builder().copy(contact).setMobileNumber("0833626973")
                .build();
        Contact updated= contactService.update(newContact);
        assertNotNull(updated);
        System.out.println(updated.toString());

    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println(contactService.getAll());
    }
}