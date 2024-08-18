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
    private  CustomerService customerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ReviewService reviewService;

    private static Customer customer;
    private static Product product;
    private static Review review;


    @Test
    @Order(0)
    void setup(){
        customer = CustomerFactory.buildCustomer(1, "Jake", "Long"
                , "jake.long@gmail.com", "jakeLong", "0677784626"
                , LocalDate.of(2000, Month.JANUARY, 1));
        String imageUrl = "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=";
        product = ProductFactory.buildProduct( "Jalapeno", "Red hot jalapeno"
                , 50, imageUrl, 5, "Plant");
        review = ReviewFactory.buildReview(1, "These Jalapenos are good"
                , LocalDate.of(2024, Month.JUNE, 15), product, customer);
    }

    @Test
    @Order(1)
    void create() {
        Customer createCustomer = customerService.create(customer);
        assertNotNull(createCustomer);
        System.out.println(createCustomer);
        Product createProduct = productService.create(product);
        assertNotNull(createProduct);
        System.out.println(createProduct);
        Review createReview = reviewService.create(review);
        assertNotNull(createReview);
        System.out.println(createReview);
    }

    @Test
    @Order(2)
    void read() {
        Review findReview = reviewService.read(review.getReviewId());
        assertNotNull(findReview);
        System.out.println(findReview);
    }

    @Test
    @Order(3)
    void update() {
        Review newReview = new Review.Builder().copy(review).setComment("These Jalapenos are terrible").build();
        assertNotNull(newReview);
        Review updatedReview = reviewService.update(newReview);
        assertNotNull(updatedReview);
        System.out.println(updatedReview);
    }

    @Test
    @Order(5)
    void delete() {
        boolean deleteReview = reviewService.delete(review.getReviewId());
        assertTrue(deleteReview);
        System.out.println(deleteReview);
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(reviewService.getAll());
    }
}