package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Coupon;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class CouponFactoryTest {

    private Coupon couponA;
    private Coupon couponB;

    @Test
    void buildCoupon() {
        couponA = CouponFactory.buildCoupon(1, "1234", 200
                , LocalDate.of(2025, Month.APRIL, 25), 200);
        assertNotNull(couponA);
        System.out.println(couponA);
    }

    @Test
    void buildCouponFail() {
        couponB = CouponFactory.buildCoupon(1, "1234", 200
                , LocalDate.of(2025, Month.APRIL, 25), -500);
        assertNotNull(couponB);
        System.out.println(couponB);
    }

}