package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderLine;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class OrderLineFactoryTest {

    @Test
    void buildOrderLine() {
        Order order = OrderFactory.buildOrder(45789, new Date(), 1500, "Received");
        OrderLine orderLine = OrderLineFactory.buildOrderLine(5554, "Roses", 5, 100, order);
        assertNotNull(orderLine);
        System.out.println(orderLine.toString());
    }

    @Test
    void testBuildOrderLine() {
        OrderLine orderLine = OrderLineFactory.buildOrderLine(3001587, "Flowers", 5, 150);
        assertNotNull(orderLine);
        System.out.println(orderLine.toString());
    }
}