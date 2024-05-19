package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Review;
import za.ac.cput.factory.ReviewFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReviewServiceTest {

    @Autowired
    private ReviewService reviewService;

    static Product product = new Product();
    static Customer customer = new Customer();
    private Review review = ReviewFactory.createProductReview(product, customer, 4, "Bad Quality", LocalDate.now());

    @Test
    @Order(1)
    void b_create() {
        Review created = reviewService.create(review);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void c_read() {
        Review read = reviewService.read(review.getReviewId());
        System.out.println(read);
    }

    @Test
    @Order(3)
    void d_update() {
        Review newReview = new Review.Builder()
                .copy(review)
                .setComment("Beautiful Sunflowers")
                .build();
        Review update = reviewService.update(newReview);
        assertNotNull(update);
        System.out.println(update);
    }

    @Test
    @Order(4)
    void e_getAll() {
        assertFalse(reviewService.getall().isEmpty());
        System.out.println(reviewService.getall());
    }
}
