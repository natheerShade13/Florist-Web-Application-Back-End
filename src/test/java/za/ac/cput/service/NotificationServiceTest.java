package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Notification;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NotificationServiceTest {

    @Autowired
    private NotificationService notificationService;

    private static Notification notification1;
    private static Notification notification2;

    @BeforeAll
    static void setup() {
        notification1 = new Notification.Builder().setNotificationId(1L).setMessage("Content 1").build();
        notification2 = new Notification.Builder().setNotificationId(2L).setMessage("Content 2").build();
    }

    @Order(1)
    @Test
    void a_setup() {
        Assertions.assertNotNull(notification1);
        System.out.println(notification1);

        Assertions.assertNotNull(notification2);
        System.out.println(notification2);
    }

    @Order(2)
    @Test
    void b_saveNotification() {
        Notification savedNotification1 = notificationService.saveNotification(notification1);
        Assertions.assertNotNull(savedNotification1);
        System.out.println(savedNotification1);

        Notification savedNotification2 = notificationService.saveNotification(notification2);
        Assertions.assertNotNull(savedNotification2);
        System.out.println(savedNotification2);
    }

    @Order(3)
    @Test
    void c_getNotificationById() {
        Notification retrievedNotification = notificationService.getNotificationById(notification2.getNotificationId());
        Assertions.assertNotNull(retrievedNotification);
        System.out.println(retrievedNotification);
    }

    @Order(4)
    @Test
    void d_updateNotification() {
        Notification updatedNotification = new Notification.Builder()
                .copy(notification2)
                .setMessage("Updated Content")
                .build();

        Notification result = notificationService.updateNotification(updatedNotification);
        Assertions.assertNotNull(result);
        System.out.println(result);
    }

    @Order(5)
    @Test
    void e_getAllNotifications() {
        Assertions.assertFalse(notificationService.getAllNotifications().isEmpty());
        System.out.println(notificationService.getAllNotifications());
    }

    @Order(6)
    @Test
    void f_deleteNotification() {
        notificationService.deleteNotification(notification1.getNotificationId());
        Notification deletedNotification = notificationService.getNotificationById(notification1.getNotificationId());
        Assertions.assertNull(deletedNotification);

        notificationService.deleteNotification(notification2.getNotificationId());
        Notification deletedNotification2 = notificationService.getNotificationById(notification2.getNotificationId());
        Assertions.assertNull(deletedNotification2);
    }
}
