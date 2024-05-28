package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderLine;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.factory.OrderLineFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    @Autowired
    private  OrderLineService orderLineService;
    private static Order order1;

    private static Order order2;

    @Test
    @BeforeEach
    void a_setup() {
        OrderLine orderLine1 = OrderLineFactory.buildOrderLine(30081, "Rose", 4, 500);
        assertNotNull(orderLine1);
        List<OrderLine> orderLineList1 = new ArrayList<>();
        orderLineList1.add(orderLine1);
        order1 = OrderFactory.buildOrder(45789, new Date(), 1500, "Received", orderLineList1);
        System.out.println(order1);

        OrderLine orderLine2 = OrderLineFactory.buildOrderLine(30082, "Flowers", 4, 500);
        orderLineService.create(orderLine2);
        orderLineService.create(orderLine1);

        assertNotNull(orderLine2);
        List<OrderLine> orderLineList2 = new ArrayList<>();
        orderLineList2.add(orderLine2);
        order2 = OrderFactory.buildOrder(48748, new Date(), 500, "Shipped", orderLineList2);
        assertNotNull(order2);
        System.out.println(order2);
    }

    @Test
    void b_create() {
        Order created1 = orderService.create(order1);
        assertNotNull(created1);
        System.out.println(created1);

        Order created2 = orderService.create(order2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    void c_read() {
        Order read = orderService.read(order2.getOrderId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        Order newOrder = new Order.Builder().copy(order1).setTotalAmount(1000).build();
        Order updated = orderService.update(newOrder);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void getAll() {
        System.out.println(orderService.getAll());

    }
}