package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderLineServiceTest {

    @Autowired
    private CouponService couponService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderLineService orderLineService;

    private static Customer customer;
    private static Coupon coupon;
    private static Orders orders;
    private static Product product;
    private static OrderLine orderLine;

    @Test
    @Order(0)
    void setUp() {
        customer = CustomerFactory.buildCustomer("Jake", "Long"
                , "long@gmail.com", "jakeLong", "0677784626"
                , LocalDate.of(2000, Month.JANUARY, 1));
        orders = OrdersFactory.buildOrder(2, 250
                , LocalDate.of(2024, Month.FEBRUARY, 25), "On route", customer, coupon);
        String imageUrl = "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=";
        product = ProductFactory.buildProduct(2, "Jalapeno", "Red hot jalapeno"
                , 50, imageUrl, 5, "Plant");
        orderLine = OrderLineFactory.buildOrderLine(2, orders, product, 5, 250);
    }

    @Test
    @Order(1)
    void create() {
        Customer createCustomer = customerService.create(customer);
        assertNotNull(createCustomer);
        System.out.println(createCustomer);
        Orders createOrders = ordersService.create(orders);
        assertNotNull(createOrders);
        System.out.println(createOrders);
        Product createProduct = productService.create(product);
        assertNotNull(createProduct);
        System.out.println(createProduct);
        OrderLine createOrderLine = orderLineService.create(orderLine);
        assertNotNull(createOrderLine);
        System.out.println(createOrderLine);
    }

    @Test
    @Order(2)
    void read() {
        OrderLine findOrderLine = orderLineService.read(orderLine.getOrderLineId());
        assertNotNull(findOrderLine);
        System.out.println(findOrderLine);
    }

    @Test
    @Order(3)
    void update() {
        OrderLine newOrderLine = new OrderLine.Builder().copy(orderLine).setQuantity(4).setQuotedPrice(400).build();
        assertNotNull(newOrderLine);
        OrderLine updatedOrderLine = orderLineService.update(newOrderLine);
        assertNotNull(updatedOrderLine);
        System.out.println(updatedOrderLine);
    }

    @Test
    @Order(5)
    //@Disabled
    void delete() {
        boolean deleteOrderLine = orderLineService.delete(orderLine.getOrderLineId());
        assertNotNull(deleteOrderLine);
        System.out.println(deleteOrderLine);
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(orderLineService.getAll());
    }
}