package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Contact;

import static org.junit.jupiter.api.Assertions.*;

class ContactFactoryTest {

    private Contact contactA;
    private Contact contactB;

    @Test
    void buildContact() {
        contactA = ContactFactory.buildContact("jake.long@gmail.com", "0677784626");
        assertNotNull(contactA);
        System.out.println(contactA);
    }

    @Test
    void buildContactFail() {
        contactB = ContactFactory.buildContact("asdasdasd", "0677784626");
        assertNotNull(contactB);
        System.out.println(contactB);
    }

}