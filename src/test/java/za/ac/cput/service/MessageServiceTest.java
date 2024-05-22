package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Message;

import java.util.Set;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MessageServiceTest {

    @Autowired
    private MessageService messageService;

    private static Message message1;
    private static Message message2;

    @BeforeAll
    static void setup() {
        message1 = new Message.Builder().setMessageId(1L).setSubject("Subject 1").setMessageContent("Message 1").build();
        message2 = new Message.Builder().setMessageId(2L).setSubject("Subject 2").setMessageContent("Message 2").build();
    }

    @Order(1)
    @Test
    void a_setup() {
        Assertions.assertNotNull(message1);
        System.out.println(message1);

        Assertions.assertNotNull(message2);
        System.out.println(message2);
    }

    @Order(2)
    @Test
    void b_saveMessage() {
        Message savedMessage1 = messageService.saveMessage(message1);
        Assertions.assertNotNull(savedMessage1);
        System.out.println(savedMessage1);

        Message savedMessage2 = messageService.saveMessage(message2);
        Assertions.assertNotNull(savedMessage2);
        System.out.println(savedMessage2);
    }

    @Order(3)
    @Test
    void c_getMessageById() {
        Message retrievedMessage = messageService.getMessageById(message2.getMessageId());
        Assertions.assertNotNull(retrievedMessage);
        System.out.println(retrievedMessage);
    }

    @Order(4)
    @Test
    void d_updateMessage() {
        Message updatedMessage = new Message.Builder()
                .copy(message2)
                .setMessageContent("Updated Message 2")
                .build();
        Message result = messageService.updateMessage(updatedMessage);
        Assertions.assertNotNull(result);
        System.out.println(result);
    }

    @Order(5)
    @Test
    void e_getAllMessages() {
        Set<Message> allMessages = messageService.getAllMessages();
        Assertions.assertFalse(allMessages.isEmpty());
        System.out.println(allMessages);
    }
}
