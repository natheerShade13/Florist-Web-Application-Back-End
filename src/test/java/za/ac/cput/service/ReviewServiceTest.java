package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Review;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.ProductFactory;
import za.ac.cput.factory.ReviewFactory;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReviewServiceTest {

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;

    private static Customer customer;
    private static Product product;
    private static Review reviewA;

    @Test
    @Order(0)
    void setUp() {
        customer = CustomerFactory.buildCustomer("Jake", "Long",
                "keitumetse@gmail.com", "jakeLong", "0677784626",
                LocalDate.of(2000, Month.JANUARY, 1));
        customer = customerService.create(customer);

        String imageUrl = "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=";
        product = ProductFactory.buildProduct("Jalapeno", "Red hot jalapeno",
                50, imageUrl, 5, "Plant");
        product = productService.create(product); // Save product to database

        reviewA = ReviewFactory.createReview("the flowers smell good", 5,
                LocalDate.of(2024, Month.JUNE, 15), product, customer);
        assertNotNull(reviewA);
        System.out.println(reviewA);
    }

    @Test
    @Order(1)
    void create() {

        Review createdReview = reviewService.create(reviewA);
        assertNotNull(createdReview);
        System.out.println(createdReview);
    }

    @Test
    @Order(2)
    void read() {
        Review foundReview = reviewService.read(reviewA.getReviewId()).orElse(null);
        assertNotNull(foundReview);
        System.out.println(foundReview);
    }

    @Test
    @Order(3)
    @Disabled
    void update() {
        Review updatedReview = new Review.Builder().copy(reviewA).setComment("Updated comment").build();
        Review savedReview = reviewService.update(updatedReview);
        assertNotNull(savedReview);
        assertEquals("Updated comment", savedReview.getComment());
        System.out.println(savedReview);
    }

    @Test
    @Order(4)
    @Disabled
    void delete() {
        boolean isDeleted = reviewService.delete(reviewA.getReviewId());
        assertTrue(isDeleted);
        System.out.println("Deleted: " + isDeleted);
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println(reviewService.getAll());
    }
}
