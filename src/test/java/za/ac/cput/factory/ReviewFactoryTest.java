package za.ac.cput.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.core.annotation.Order;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Review;
import java.time.LocalDate;

@TestMethodOrder(OrderAnnotation.class)
public class ReviewFactoryTest {

    private Review reviewA;
    private Review reviewB;

    @Test
    @Order(1)
    void createReview() {
        Product product = new Product();
        Customer customer = new Customer();
        LocalDate reviewDateA = LocalDate.now();
        reviewA = ReviewFactory.createProductReview(product, customer, 5, "Beautiful sunflowers", reviewDateA);
        Assertions.assertNotNull(reviewA);
        Assertions.assertEquals(5, reviewA.getRating());
        Assertions.assertEquals("Beautiful sunflowers", reviewA.getComment());
        Assertions.assertEquals(reviewDateA, reviewA.getReviewDate());
        System.out.println(reviewA);
    }

    @Test
    @Order(2)
    void testCreateReview() {
        Product productb = new Product();
        Customer customerb = new Customer();
        LocalDate reviewDateB = LocalDate.of(2021, 8, 10);
        reviewB = ReviewFactory.createProductReview(productb, customerb, 3, "Roses were nice but not fresh", reviewDateB);
        Assertions.assertNotNull(reviewB);
        Assertions.assertEquals(3, reviewB.getRating());
        Assertions.assertEquals("Roses were nice but not fresh", reviewB.getComment());
        Assertions.assertEquals(reviewDateB, reviewB.getReviewDate());
        System.out.println(reviewB);
    }
}
