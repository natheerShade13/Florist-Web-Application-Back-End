package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderLine;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderFactoryTest {

    @Test
    void buildOrder() {
            OrderLine orderLine = OrderLineFactory.buildOrderLine(30081, "Rose", 4, 500);
            assertNotNull(orderLine);
            List<OrderLine> orderLineList = new ArrayList<>();
            orderLineList.add(orderLine);

            Order order = OrderFactory.buildOrder(45789, new Date(), 1500, "Received", orderLineList);
            assertNotNull(order);
            System.out.println(order.toString());
        }
}