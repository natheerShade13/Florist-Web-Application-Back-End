package za.ac.cput.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Message;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MessageServiceTest {

    @Autowired
    private MessageService messageService;

    @Autowired
    private CustomerService customerService;

    @Test
    void createMessage() {
        Customer customer = new Customer.Builder()
                .setFirstName("Kakashi")
                .setLastName("Hatake")
                .setContact("kakashihatake@gmail.com")
                .build();

        customer = customerService.create(customer);
        assertNotNull(customer);

        Message message = new Message.Builder()
                .setSubject("Test subject")
                .setMessageContent("Test message content")
                .setIsRead(false)
                .setDateSent(new Date())
                .setCustomer(customer)
                .build();

        message = messageService.create(message);
        assertNotNull(message);
        System.out.println(message);
    }

    @Test
    void readMessages() {
        Iterable<Message> messages = messageService.getAllMessages();

        assertNotNull(messages);
        messages.forEach(System.out::println);
    }

    @Test
    void updateMessage() {
        long messageId = 1L;

        Message message = messageService.read(messageId);

        assertNotNull(message, "Message with id " + messageId + " not found");

        message = new Message.Builder()
                .copy(message)
                .setMessageContent("Updated content")
                .build();

        message = messageService.update(message);

        assertNotNull(message);
        assertEquals("Updated content", message.getMessageContent());
        System.out.println(message);
    }

    @Test
    void deleteMessage() {
        long messageId = 1L;

        messageService.delete(messageId);

        assertNull(messageService.read(messageId));
    }
}
