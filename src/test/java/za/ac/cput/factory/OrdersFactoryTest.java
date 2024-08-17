package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Coupon;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Orders;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class OrdersFactoryTest {

    private Customer customer;
    private Coupon coupon;
    private Orders ordersA;
    private Orders ordersB;

    @Test
    void ordersFactory() {
        customer = CustomerFactory.buildCustomer("Jake", "Long"
                , "jake.long@gmail.com", "jakeLong", "0677784626"
                , LocalDate.of(2000, Month.JANUARY, 1));
        coupon = CouponFactory.buildCoupon(1, "1234", 200
                , LocalDate.of(2025, Month.APRIL, 25), 400);
        ordersA = OrdersFactory.buildOrder(1, 250
                , LocalDate.of(2024, Month.FEBRUARY, 25), "On route", customer, coupon);
        assertNotNull(ordersA);
        System.out.println(ordersA);
    }

    @Test
    void ordersFactoryFail() {
        customer = CustomerFactory.buildCustomer("Jake", "Long"
                , "jake.long@gmail.com", "jakeLong", "0677784626"
                , LocalDate.of(2000, Month.JANUARY, 1));
        coupon = CouponFactory.buildCoupon(1, "1234", 200
                , LocalDate.of(2025, Month.APRIL, 25), 400);
        ordersB = OrdersFactory.buildOrder(1, 500
                , LocalDate.of(2024, Month.FEBRUARY, 25), "", customer, coupon);
        assertNotNull(ordersB);
        System.out.println(ordersB);
    }

}