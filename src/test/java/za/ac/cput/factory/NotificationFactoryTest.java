package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Notification;
import za.ac.cput.utility.NotificationHelper;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NotificationFactoryTest {

    private Notification notificationA;

    /*
    private Notification notificationB;
    private Notification notificationC;
    */

    @Test
    @Order(1)
    void createNotification() {
        Customer customerA = new Customer.Builder().build();
        Date dateSentA = new Date();
        notificationA = NotificationFactory.createNotification(NotificationHelper.generateUniqueID(), customerA, "Test Message A", false, dateSentA);
        assertNotNull(notificationA);
        System.out.println(notificationA);
    }

    /*
    @Test
    @Order(2)
    void copyCreateNotification() {
        Customer customerB = new Customer.Builder().build();
        Date dateSentB = new Date();
        notificationC = NotificationFactory.createNotification(NotificationHelper.generateID(), customerB, "Test Message B", false, dateSentB);
        notificationB = new Notification.Builder().copy(notificationC).setMessage("Updated Test Message B").build();
        assertNotNull(notificationB);
        System.out.println(notificationB);
    }
     */
}
