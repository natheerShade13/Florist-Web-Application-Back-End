package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.OrderLine;
import za.ac.cput.factory.OrderLineFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class OrderLineServiceTest {
    @Autowired
    private OrderLineService orderLineService;

    private static OrderLine orderLine1;
    private static OrderLine orderLine2;

    @Test
    @BeforeEach
    void a_setup() {
        orderLine1 = OrderLineFactory.buildOrderLine(224578, "Flower", 4, 2700);
        System.out.println(orderLine1);
        orderLine2 = OrderLineFactory.buildOrderLine(227892, "Roses", 1, 500);
        assertNotNull(orderLine2);
        System.out.println(orderLine2);
    }

    @Test
    void b_create() {
        OrderLine created1 = orderLineService.create(orderLine1);
        assertNotNull(created1);
        System.out.println(created1);

        OrderLine created2 = orderLineService.create(orderLine2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    void c_read() {
        OrderLine read = orderLineService.read(orderLine2.getOrderLineId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        OrderLine newOrderLine = new OrderLine.Builder().copy(orderLine1).setItem("Bouquet").build();
        OrderLine updated = orderLineService.update(newOrderLine);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void getAll() {
        System.out.println(orderLineService.getAll());
    }
}