package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Review {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id", nullable = false)
    private long reviewId;

    @Column(name = "customer_id", nullable = false)
    private long customerId;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "comment")
    private String comment;

    @Column(name = "review_date", nullable = false)
    private LocalDate reviewDate;

    @ManyToOne
    @JoinColumn(name = "product_id") // This specifies the column name in the review table
    private Product product;

    public Review() {
    }

    private Review(Builder builder) {
        this.reviewId = builder.reviewId;
        this.customerId = builder.customerId;
        this.rating = builder.rating;
        this.comment = builder.comment;
        this.reviewDate = builder.reviewDate;
    }

    // Getters
    public long getReviewId() {
        return reviewId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public int getRating() {
        return rating;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(reviewId, review.reviewId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId);
    }

    // toString method
    @Override
    public String toString() {
        return "Product Review:\n" +
                "Review ID: " + reviewId + '\n' +
                "Customer ID: " + customerId + '\n' +
                "Rating: " + rating + '\n' +
                "Comment: " + comment + '\n' +
                "Review Date: " + reviewDate+ '\n';
    }

    // Builder class
    public static class Builder {
        private long reviewId;
        private long customerId;
        private int rating;
        private String comment;
        private LocalDate reviewDate;

        public Builder setReviewId(long reviewId) {
            this.reviewId = reviewId;
            return this;
        }

        public Builder setCustomerId(long customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setRating(int rating) {
            this.rating = rating;
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

        public Builder copy(Review review) {
            this.reviewId = review.reviewId;
            this.customerId = review.customerId;
            this.rating = review.rating;
            this.comment = review.comment;
            this.reviewDate = review.reviewDate;
            return this;
        }

        public Review build() {
            return new Review(this);
        }
    }
}
