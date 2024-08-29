package za.ac.cput.factory;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Review;
import za.ac.cput.util.ReviewHelper;

import java.time.LocalDate;

public class ReviewFactory {

    public static Review createReview(String comment, int rating, LocalDate localDate, Product product, Customer customer) {

        if (ReviewHelper.isNullOrEmpty(comment) || product == null || customer == null || rating < 1 || rating > 5) {
            return null;
        }

        return new Review.Builder()
                .setComment(comment)
                .setRating(rating)
                .setReviewDate(LocalDate.now())
                .setProduct(product)
                .setCustomer(customer)
                .build();
    }
}
