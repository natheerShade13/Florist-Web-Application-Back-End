package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "promotion")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promotion_id", nullable = false)
    private long promotionId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Column(name = "discount_type", nullable = false)
    private String discountType;

    @Column(name = "discount_amount", nullable = false)
    private double discountAmount;

    protected Promotion() {
    }

    public Promotion(Builder builder){
        this.promotionId = builder.promotionId;
        this.name = builder.name;
        this.description = builder.description;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.discountType = builder.discountType;
        this.discountAmount = builder.discountAmount;
    }

    public String getDescription() {
        return description;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public String getDiscountType() {
        return discountType;
    }

    public Date getEndDate() {
        return endDate;
    }

    public long getPromotionId() {
        return promotionId;
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Promotion that = (Promotion) o;
        return Double.compare(that.discountAmount, discountAmount) == 0 && Objects.equals(promotionId, that.promotionId) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(discountType, that.discountType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(promotionId, name, description, startDate, endDate, discountType, discountAmount);
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "description='" + description + '\'' +
                ", promotionId='" + promotionId + '\'' +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", discountType='" + discountType + '\'' +
                ", discountAmount=" + discountAmount +
                '}';
    }

    public static class Builder{

        private long promotionId;
        private String name;
        private String description;
        private Date startDate;
        private Date endDate;
        private String discountType;
        private double discountAmount;

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setDiscountAmount(double discountAmount) {
            this.discountAmount = discountAmount;
            return this;
        }

        public Builder setEndDate(Date endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder setDiscountType(String discountType) {
            this.discountType = discountType;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPromotionId(long promotionId) {
            this.promotionId = promotionId;
            return this;
        }

        public Builder setStartDate(Date startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder copy(Promotion promotion){
            this.promotionId = promotion.promotionId;
            this.name = promotion.name;
            this.description = promotion.description;
            this.startDate = promotion.startDate;
            this.endDate = promotion.endDate;
            this.discountType = promotion.discountType;
            this.discountAmount = promotion.discountAmount;
            return this;
        }

        public Promotion build(){
            return new Promotion(this);
        }

    }
}
