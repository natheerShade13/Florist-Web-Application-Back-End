package za.ac.cput.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
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
@TestMethodOrder(MethodOrderer.MethodName.class)
class ReviewServiceTest {

    @Autowired
    private ReviewService reviewService;

    private static Review review1;
    private static Review review2;


    @BeforeAll
    static void setup() {
        Product product = new Product();
        Customer customer = new Customer();
        review1 = ReviewFactory.createProductReview(product, customer, 1, "Bad Quality", LocalDate.now());
        review2 = ReviewFactory.createProductReview(product, customer, 2, "Nice flowers", LocalDate.of(2024, 3, 3));
    }

    @Test
    void a_setup() {
        assertNotNull(review1);
        System.out.println(review1);

        assertNotNull(review2);
        System.out.println(review2);
    }

    @Test
    void b_create() {
        Review created1 = reviewService.create(review1);
        assertNotNull(created1);
        System.out.println(created1);

        Review created2 = reviewService.create(review2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    void c_read() {
        Review read = reviewService.read(review2.getReviewId());
        System.out.println(read);
    }

    @Test
    void d_update() {
        Review newReview = new Review.Builder()
                .copy(review2)
                .setComment("Fresh roses")
                .build();
        Review updated = reviewService.update(newReview);
        assertNotNull(updated);
        assertEquals("Fresh roses", updated.getComment());
        System.out.println(updated);
    }

    @Test
    void e_getAll() {
        assertFalse(reviewService.getall().isEmpty());
        System.out.println(reviewService.getall());
    }
}
