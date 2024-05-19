package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.OrderFactory;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    private static Order order1;

    private static Order order2;

    @Test
    void a_create() {
        order1 = OrderFactory.buildOrder(45789, new Date(), 1500, "Received", "Rose");
        System.out.println(order1);
        order2 = OrderFactory.buildOrder(48748, new Date(), 500, "Shipped", "Flowers");
        System.out.println(order2);
        assertNotNull(order2);
        System.out.println(order2);
    }

    @Test
    void b_read() {
        Order created1 = orderService.create(order1);
        assertNotNull(created1);
        System.out.println(created1);

        Order created2 = orderService.create(order2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    void d_update() {
        Order newOrder = new Order.Builder().copy(order1).setOrderLine("bouquet").build();
        Order updated = orderService.update(newOrder);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void getAll() {
        System.out.println(orderService.getAll());
    }


}