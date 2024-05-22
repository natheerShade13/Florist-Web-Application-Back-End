package za.ac.cput.factory;

import za.ac.cput.domain.Review;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Customer;
import za.ac.cput.utility.ReviewHelper;

import java.time.LocalDate;

public class ReviewFactory {
    public static Review createProductReview(Product product, Customer customer, int rating, String comment, LocalDate reviewDate) {
        if (product == null || customer == null || rating < 1 || rating > 5 || ReviewHelper.isNullOrEmpty(comment) || reviewDate == null) {
            return null;
        }

        long reviewId = ReviewHelper.generateUniqueID();
        return new Review.Builder()
                .setReviewId(reviewId)
                .setRating(rating)
                .setComment(comment)
                .setReviewDate(reviewDate)
                .build();
    }
}
