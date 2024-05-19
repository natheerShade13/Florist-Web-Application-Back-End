package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Order;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class OrderFactoryTest {

    @Test
    void buildOrder() {
        Order order = OrderFactory.buildOrder(45789, new Date(), 1500, "Received", "Rose");
        assertNotNull(order);
        System.out.println(order.toString());
    }
}