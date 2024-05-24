package za.ac.cput.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Notification;
import za.ac.cput.repository.CustomerRepository;

import java.util.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NotificationServiceTest {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void createNotification() {
        Customer customer = new Customer();
        customer = customerRepository.save(customer);

        Notification notification = new Notification.Builder()
                .setMessage("Test notification")
                .setIsRead(false)
                .setDateSent(new Date())
                .setCustomer(customer)
                .build();

        notification = notificationService.create(notification);
        assertNotNull(notification);
        System.out.println(notification);
    }

    @Test
    void readNotifications() {
        Set<Notification> notifications = notificationService.getAllNotifications();

        assertNotNull(notifications);
        assertFalse(notifications.isEmpty());
        System.out.println(notifications);
    }

    @Test
    void updateNotification() {
        long notificationId = 1L;

        Notification notification = notificationService.read(notificationId);

        assertNotNull(notification, "Notification with id " + notificationId + " not found");

        notification = new Notification.Builder()
                .setNotificationId(notificationId)
                .setIsRead(true)
                .build();

        notification = notificationService.update(notification);

        assertNotNull(notification);
        assertTrue(notification.isRead());
        System.out.println(notification);
    }

    @Test
    void deleteNotification() {
        long notificationId = 1L;

        notificationService.delete(notificationId);

        assertNull(notificationService.read(notificationId));
    }
}
