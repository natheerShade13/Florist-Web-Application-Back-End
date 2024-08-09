package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Coupon {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long couponId;
    private String code;
    private double discountAmount;
    private LocalDate expiryDate;
    private double minimumOrderAmount;
    //@OneToMany(mappedBy = "coupon")
    //private List<Orders> orders;
    // Add isUsed boolean variable

    protected Coupon(){}

    private Coupon(Builder builder){
        this.couponId = builder.couponId;
        this.code = builder.code;
        this.discountAmount = builder.discountAmount;
        this.expiryDate = builder.expiryDate;
        this.minimumOrderAmount = builder.minimumOrderAmount;
    }

    public long getCouponId() {
        return couponId;
    }

    public String getCode() {
        return code;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public double getMinimumOrderAmount() {
        return minimumOrderAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coupon coupon = (Coupon) o;
        return couponId == coupon.couponId && Double.compare(discountAmount, coupon.discountAmount) == 0 && Double.compare(minimumOrderAmount, coupon.minimumOrderAmount) == 0 && Objects.equals(code, coupon.code) && Objects.equals(expiryDate, coupon.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(couponId, code, discountAmount, expiryDate, minimumOrderAmount);
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "couponId=" + couponId +
                ", code='" + code + '\'' +
                ", discountAmount=" + discountAmount +
                ", expiryDate=" + expiryDate +
                ", minimumOrderAmount=" + minimumOrderAmount +
                '}';
    }

    public static class Builder{

        private long couponId;
        private String code;
        private double discountAmount;
        private LocalDate expiryDate;
        private double minimumOrderAmount;

        public Builder setCouponId(long couponId) {
            this.couponId = couponId;
            return this;
        }

        public Builder setCode(String code) {
            this.code = code;
            return this;
        }

        public Builder setDiscountAmount(double discountAmount) {
            this.discountAmount = discountAmount;
            return this;
        }

        public Builder setExpiryDate(LocalDate expiryDate) {
            this.expiryDate = expiryDate;
            return this;
        }

        public Builder setMinimumOrderAmount(double minimumOrderAmount) {
            this.minimumOrderAmount = minimumOrderAmount;
            return this;
        }

        public Builder copy(Coupon coupon){
            this.couponId = coupon.couponId;
            this.code = coupon.code;
            this.discountAmount = coupon.discountAmount;
            this.expiryDate = coupon.expiryDate;
            this.minimumOrderAmount = coupon.minimumOrderAmount;
            return this;
        }

        public Coupon build(){return new Coupon(this);}

    }

}
