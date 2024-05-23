package za.ac.cput.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Notification;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class NotificationServiceTest {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private CustomerService customerService;

    @Test
    void a_create() {
        Customer customer = new Customer.Builder()
                .setCustomerId(1L)
                .setFirstName("Sasuke")
                .build();
        customerService.create(customer);

        Notification.Builder builder = new Notification.Builder();
        builder.setCustomer(customer)
                .setMessage("This is a test notification.")
                .setIsRead(false)
                .setDateSent(new Date());
        Notification notification = builder.build();

        notificationService.create(notification);
        assertNotNull(notification.getNotificationId());
    }

    @Test
    void b_read() {
        a_create();
        Notification notification = notificationService.getAllNotifications().stream().findFirst().orElse(null);
        assertNotNull(notification);
        Notification foundNotification = notificationService.read(notification.getNotificationId());
        assertNotNull(foundNotification);
        assertEquals(notification.getMessage(), foundNotification.getMessage());
        assertEquals(notification.getCustomer().getCustomerId(), foundNotification.getCustomer().getCustomerId());
    }

    @Test
    void c_update() {
        a_create();
        Notification notification = notificationService.getAllNotifications().stream().findFirst().orElse(null);
        assertNotNull(notification);
        String newMessage = "Updated notification content";
        Notification.Builder builder = new Notification.Builder().copy(notification);
        builder.setMessage(newMessage)
                .setIsRead(true);
        Notification updatedNotification = builder.build();
        notificationService.update(updatedNotification);
        Notification retrievedNotification = notificationService.read(notification.getNotificationId());
        assertEquals(newMessage, retrievedNotification.getMessage());
        assertTrue(retrievedNotification.isRead());
    }

    @Test
    void d_delete() {
        a_create();
        Notification notification = notificationService.getAllNotifications().stream().findFirst().orElse(null);
        assertNotNull(notification);
        notificationService.delete(notification.getNotificationId());
        Notification deletedNotification = notificationService.read(notification.getNotificationId());
        assertNull(deletedNotification);
    }
}
