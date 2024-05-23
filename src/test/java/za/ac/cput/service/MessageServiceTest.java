package za.ac.cput.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Message;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MessageServiceTest {

    @Autowired
    private MessageService messageService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmployeeService employeeService;

    @Test
    void a_create() {
        Customer customer = new Customer.Builder()
                .setFirstName("Minato")
                .build();
        customerService.create(customer);

        Employee employee = new Employee.Builder()
                .setName("Kakashi")
                .setEmail("kakashi@gmail.com")
                .setAddress("123 Main St")
                .setPhone("123-456-7890")
                .setRole("Developer")
                .build();
        employeeService.create(employee);

        Message message = new Message.Builder()
                .setSubject("Test Subject")
                .setMessageContent("Hello, this is a test message.")
                .setIsRead(false)
                .setDateSent(new Date())
                .setCustomer(customer)
                .setEmployee(employee)
                .build();

        messageService.create(message);
        assertNotNull(message.getMessageId());
    }

    @Test
    void b_read() {
        a_create();
        Message message = messageService.getAllMessages().stream().findFirst().orElse(null);
        assertNotNull(message);
        Message foundMessage = messageService.read(message.getMessageId());
        assertNotNull(foundMessage);
        assertEquals(message.getSubject(), foundMessage.getSubject());
        assertEquals(message.getMessageContent(), foundMessage.getMessageContent());
        assertEquals(message.isRead(), foundMessage.isRead());
        assertEquals(message.getDateSent(), foundMessage.getDateSent());
        assertEquals(message.getCustomer().getCustomerId(), foundMessage.getCustomer().getCustomerId());
        assertEquals(message.getEmployee().getEmployeeId(), foundMessage.getEmployee().getEmployeeId());
    }

    @Test
    void c_update() {
        a_create();
        Message message = messageService.getAllMessages().stream().findFirst().orElse(null);
        assertNotNull(message);
        String newContent = "Updated message content";
        Message updatedMessage = new Message.Builder()
                .copy(message)
                .setMessageContent(newContent)
                .build();
        messageService.update(updatedMessage);
        Message retrievedMessage = messageService.read(message.getMessageId());
        assertEquals(newContent, retrievedMessage.getMessageContent());
    }

    @Test
    void d_delete() {
        a_create();
        Message message = messageService.getAllMessages().stream().findFirst().orElse(null);
        assertNotNull(message);
        messageService.delete(message.getMessageId());
        Message deletedMessage = messageService.read(message.getMessageId());
        assertNull(deletedMessage);
    }
}
