package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Coupon;
import za.ac.cput.factory.CouponFactory;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CouponServiceTest {

    @Autowired
    private CouponService couponService;

    private static Coupon coupon;

    @Test
    @Order(0)
    void setup() {
        coupon = CouponFactory.buildCoupon(1, "1234", 200
                , LocalDate.of(2025, Month.APRIL, 25), 200);
    }

    @Test
    @Order(1)
    void create() {
        Coupon createCoupon = couponService.create(coupon);
        assertNotNull(createCoupon);
        System.out.println(createCoupon);
    }

    @Test
    @Order(2)
    void read() {
        Coupon findCoupon = couponService.read(coupon.getCouponId());
        assertNotNull(findCoupon);
        System.out.println(findCoupon);
    }

    @Test
    @Order(3)
    void update() {
        Coupon newCoupon = new Coupon.Builder().copy(coupon)
                .setExpiryDate(LocalDate.of(2025, Month.JANUARY, 30)).build();
        assertNotNull(newCoupon);
        System.out.println(newCoupon);
        Coupon updateCoupon = couponService.update(newCoupon);
        assertNotNull(updateCoupon);
        System.out.println(updateCoupon);
    }

    @Test
    @Order(5)
    //@Disabled
    void delete() {
        boolean deleteCoupon = couponService.delete(coupon.getCouponId());
        assertTrue(deleteCoupon);
        System.out.println(deleteCoupon);
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(couponService.getAll());
    }
}