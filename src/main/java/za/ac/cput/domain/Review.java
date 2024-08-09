package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Review {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reviewId;
    private String comment;
    private LocalDate reviewDate;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "CUS_ID")
    private Customer customer;

    protected Review() {}

    private Review(Builder builder) {
        this.reviewId = builder.reviewId;
        this.comment = builder.comment;
        this.reviewDate = builder.reviewDate;
        this.product = builder.product;
        this.customer = builder.customer;
    }

    public long getReviewId() {
        return reviewId;
    }

    public String getComment() {
        return comment;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public Product getProduct() {
        return product;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return reviewId == review.reviewId && Objects.equals(comment, review.comment) && Objects.equals(reviewDate, review.reviewDate) && Objects.equals(product, review.product) && Objects.equals(customer, review.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, comment, reviewDate, product, customer);
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", comment='" + comment + '\'' +
                ", reviewDate=" + reviewDate +
                ", product=" + product +
                ", customer=" + customer +
                '}';
    }

    // Builder class
    public static class Builder {
        private long reviewId;
        private String comment;
        private LocalDate reviewDate;
        private Product product;
        private Customer customer;

        public Builder setReviewId(long reviewId) {
            this.reviewId = reviewId;
            return this;
        }

        public Builder setComment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder setReviewDate(LocalDate reviewDate) {
            this.reviewDate = reviewDate;
            return this;
        }

        public Builder setProduct(Product product) {
            this.product = product;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder copy(Review review) {
            this.reviewId = review.reviewId;
            this.comment = review.comment;
            this.reviewDate = review.reviewDate;
            this.product = review.product;
            this.customer = review.customer;
            return this;
        }

        public Review build() {
            return new Review(this);
        }
    }

}
