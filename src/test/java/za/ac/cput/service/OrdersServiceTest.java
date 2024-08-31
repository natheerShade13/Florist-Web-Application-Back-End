package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Coupon;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Orders;
import za.ac.cput.factory.CouponFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.OrdersFactory;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrdersServiceTest {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private CouponService couponService;
    @Autowired
    private CustomerService customerService;

    private static Customer customer;
    private static Coupon coupon;
    private static Orders orders;

    @Test
    @Order(0)
    void setUp() {
        customer = CustomerFactory.buildCustomer("Jake", "Long"
                , "jake.long@gmail.com", "jakeLong", "0677784626"
                , LocalDate.of(2000, Month.JANUARY, 1));
        coupon = CouponFactory.buildCoupon(1, "1234", 200
                , LocalDate.of(2025, Month.APRIL, 25), 200);
        orders = OrdersFactory.buildOrder(250
                , LocalDate.of(2024, Month.FEBRUARY, 25), "On route", customer, coupon);
    }

    @Test
    @Order(1)
    void create() {
        Customer createCustomer = customerService.create(customer);
        assertNotNull(createCustomer);
        Coupon createCoupon = couponService.create(coupon);
        assertNotNull(createCoupon);
        System.out.println(createCoupon);
        System.out.println(createCustomer);
        Orders createOrders = ordersService.create(orders);
        assertNotNull(createOrders);
        System.out.println(createOrders);
    }

    @Test
    @Order(2)
    void read() {
        Orders findOrders = ordersService.read(orders.getOrderId());
        assertNotNull(findOrders);
        System.out.println(findOrders);
    }

    @Test
    @Order(3)
    void update() {
        Orders newOrders = new Orders.Builder().copy(orders).setStatus("Delivered").build();
        assertNotNull(newOrders);
        Orders updatedOrders = ordersService.update(newOrders);
        assertNotNull(updatedOrders);
        System.out.println(updatedOrders);
    }

    @Test
    @Order(6)
    //@Disabled
    void delete() {
        boolean deleteOrders = ordersService.delete(orders.getOrderId());
        assertTrue(deleteOrders);
        System.out.println(deleteOrders);
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(ordersService.getAll());
    }

    @Test
    @Order(5)
    void calculateOrder() {
        double calculateOrder = ordersService.calculateOrder(orders);
        System.out.println(calculateOrder);
    }

}