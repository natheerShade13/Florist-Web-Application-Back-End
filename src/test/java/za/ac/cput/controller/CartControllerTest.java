package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CartFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CartControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String Base_URL = "http://localhost:8080/NurseryWeb/cart";
    private static Cart cart;

    @BeforeAll
    public static void setup() {
        // Create a Customer instance
//        Customer customer = new Customer.Builder()
//                .setFirstName("Mabotse")
//                .setLastname("Mosima")
//                .build();

        // Create a Cart instance using CartFactory
        cart = CartFactory.createCart(new Customer(), LocalDate.now());
    }

    @Test
    @Order(1)
    void create() {
        String url = Base_URL + "/create";
        ResponseEntity<Cart> postResponse = restTemplate.postForEntity(url, cart, Cart.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        cart = postResponse.getBody();
        assertNotNull(cart.getCartId());
        System.out.println("Saved data: " + cart);
    }

    @Test
    @Order(2)
    void read() {
        assertNotNull(cart.getCartId());
        String url = Base_URL + "/read/" + cart.getCartId();
        System.out.println("URL: " + url);
        ResponseEntity<Cart> response = restTemplate.getForEntity(url, Cart.class);
        assertNotNull(response.getBody());
        assertEquals(cart.getCartId(), response.getBody().getCartId());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    @Order(3)
    void update() {
        assertNotNull(cart.getCartId());
        String url = Base_URL + "/update";
        Cart newCart = new Cart.Builder().copy(cart)
                .setCreatedDate(LocalDate.now().plusDays(1)) // Updated created date for example
                .build();
        ResponseEntity<Cart> postResponse = restTemplate.postForEntity(url, newCart, Cart.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Cart cartUpdated = postResponse.getBody();
        assertEquals(newCart.getCartId(), cartUpdated.getCartId());
        assertEquals(newCart.getCreatedDate(), cartUpdated.getCreatedDate());
        System.out.println("Updated data: " + cartUpdated);
    }

    @Test
    @Order(4)
    void delete() {
        assertNotNull(cart.getCartId());
        String url = Base_URL + "/delete/" + cart.getCartId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        // Confirm deletion by attempting to read the deleted cart
        ResponseEntity<Cart> response = restTemplate.getForEntity(url, Cart.class);
        assertNull(response.getBody());
        System.out.println("Success: Deleted cart");
    }

    @Test
    @Order(5)
    void getAll() {
        String url = Base_URL + "/getall";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("Show All: ");
        System.out.println(response.getBody());
    }
}
