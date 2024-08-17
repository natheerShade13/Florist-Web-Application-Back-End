package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class OrderLineFactoryTest {

    private Customer customer;
    private Coupon coupon;
    private Orders orders;
    private Product product;
    private OrderLine orderLineA;
    private OrderLine orderLineB;


    @Test
    void buildOrderLine() {
        customer = CustomerFactory.buildCustomer("Jake", "Long"
                , "jake.long@gmail.com", "jakeLong", "0677784626"
                , LocalDate.of(2000, Month.JANUARY, 1));
        coupon = CouponFactory.buildCoupon(1, "1234", 200
                , LocalDate.of(2025, Month.APRIL, 25), 400);
        orders = OrdersFactory.buildOrder(1, 250
                , LocalDate.of(2024, Month.FEBRUARY, 25), "On route", customer, coupon);
        String imageUrl = "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=";
        product = ProductFactory.buildProduct(1, "Jalapeno", "Red hot jalapeno"
                , 50, imageUrl, 5, "Plant");
        orderLineA = OrderLineFactory.buildOrderLine(1, orders, product, 5, 250);
        assertNotNull(orderLineA);
        System.out.println(orderLineA);
    }

    @Test
    void buildOrderLineFail() {
        customer = CustomerFactory.buildCustomer("Jake", "Long"
                , "jake.long@gmail.com", "jakeLong", "0677784626"
                , LocalDate.of(2000, Month.JANUARY, 1));
        coupon = CouponFactory.buildCoupon(1, "1234", 200
                , LocalDate.of(2025, Month.APRIL, 25), 400);
        orders = OrdersFactory.buildOrder(1, 250
                , LocalDate.of(2024, Month.FEBRUARY, 25), "On route", customer, coupon);
        String imageUrl = "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=";
        product = ProductFactory.buildProduct(1, "Jalapeno", "Red hot jalapeno"
                , 50, imageUrl, 5, "Plant");
        orderLineB = OrderLineFactory.buildOrderLine(1, orders, product, 0, 250);
        assertNotNull(orderLineB);
        System.out.println(orderLineB);
    }

}