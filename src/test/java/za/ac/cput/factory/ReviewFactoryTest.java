package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Review;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class ReviewFactoryTest {

    private Customer customer;
    private Product product;
    private Review reviewA;
    private Review reviewB;
    private LocalDate localDate;

    @Test
    void buildReview() {
        customer = CustomerFactory.buildCustomer("Jake", "Long"
                , "jake.long@gmail.com", "jakeLong", "0677784626"
                , LocalDate.of(2000, Month.JANUARY, 1));
        String imageUrl = "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=";
        product = ProductFactory.buildProduct("Jalapeno", "Red hot jalapeno"
                , 50, imageUrl, 5, "Plant");
        reviewA = ReviewFactory.buildReview(1, "These Jalapenos are good"
                , LocalDate.of(2024, Month.JUNE, 15), product, customer);
        assertNotNull(reviewA);
        System.out.println(reviewA);
    }

    @Test
    void buildReviewFail() {
        customer = CustomerFactory.buildCustomer("Jake", "Long"
                , "jake.long@gmail.com", "jakeLong", "0677784626"
                , LocalDate.of(2000, Month.JANUARY, 1));
        String imageUrl = "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=";
        product = ProductFactory.buildProduct( "Jalapeno", "Red hot jalapeno"
                , 50, imageUrl, 5, "Plant");
        reviewB = ReviewFactory.buildReview(1, "These Jalapenos are good"
                , localDate, product, customer);
        assertNotNull(reviewB);
        System.out.println(reviewB);
    }

}