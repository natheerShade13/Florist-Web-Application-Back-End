package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Review;
import za.ac.cput.factory.ReviewFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReviewControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String Base_URL = "http://localhost:8080/NurseryWeb/review";
    private static Review review;

    @BeforeAll
    public static void setup() {
        review = ReviewFactory.createProductReview(new Product(), new Customer(), 3, "favourite flower", LocalDate.now());
    }

    @Test
    @Order(1)
    void create() {
        String url = Base_URL + "/create";
        ResponseEntity<Review> postResponse = restTemplate.postForEntity(url, review, Review.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        review = postResponse.getBody();
        assertNotNull(review.getReviewId());
        System.out.println("Saved data: " + review);
    }

    @Test
    @Order(2)
    void read() {
        assertNotNull(review.getReviewId());
        String url = Base_URL + "/read/" + review.getReviewId();
        System.out.println("URL: " + url);
        ResponseEntity<Review> response = restTemplate.getForEntity(url, Review.class);
        review = response.getBody();
        assertNotNull(response.getBody());
        assertEquals(review.getReviewId(), response.getBody().getReviewId());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    @Order(3)
    void update() {
        assertNotNull(review.getReviewId());
        String url = Base_URL + "/update";
        Review newReview = new Review.Builder().copy(review)
                .setComment("New favors").build();
        ResponseEntity<Review> postResponse = restTemplate.postForEntity(url, newReview, Review.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Review reviewUpdated = postResponse.getBody();
        assertEquals(newReview.getReviewId(), reviewUpdated.getReviewId());
        assertEquals("New favors", reviewUpdated.getComment());
        System.out.println("Updated data: " + reviewUpdated);
    }

    @Test
    @Order(4)
    void delete() {
        assertNotNull(review.getReviewId());
        String url = Base_URL + "/delete/" + review.getReviewId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Success: Deleted review");
    }

    @Test
    @Order(5)
    void getall() {
        String url = Base_URL + "/getall";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("Show All: ");
        System.out.println(response.getBody());
    }
}
