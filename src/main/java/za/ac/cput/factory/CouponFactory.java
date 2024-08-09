package za.ac.cput.factory;

import za.ac.cput.domain.Coupon;
import za.ac.cput.util.CouponHelper;

import java.time.LocalDate;

public class CouponFactory {

    public static Coupon buildCoupon(long couponId, String code, double discountAmount, LocalDate expiryDate,
                                     double minimumOrderAmount){
        if (CouponHelper.validId(couponId) || CouponHelper.isNullOrEmpty(code)
                || CouponHelper.isNegative(discountAmount) || CouponHelper.isNull(expiryDate)
                || CouponHelper.isNegative(minimumOrderAmount)){
            return null;
        }

        return new Coupon.Builder().setCouponId(couponId).setCode(code).setDiscountAmount(discountAmount)
                .setExpiryDate(expiryDate).setMinimumOrderAmount(minimumOrderAmount).build();

    }

}
