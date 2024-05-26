package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.*;
import za.ac.cput.factory.CartItemFactory;


import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CartItemControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String Base_URL = "http://localhost:8080/NurseryWeb/cartItem";
    private static CartItem cartItem;

    @BeforeAll
    public static void setup() {
        cartItem = CartItemFactory.createCartItem(new Cart(), new Product(),3,29.00);
    }

    @Test
    @Order(1)
    void create() {
        String url = Base_URL + "/create";
        ResponseEntity<CartItem> postResponse = restTemplate.postForEntity(url, cartItem, CartItem.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        cartItem = postResponse.getBody();
        assertNotNull(cartItem.getCartItemId());
        System.out.println("Saved data: " + cartItem);
    }

    @Test
    @Order(2)
    void read() {
        assertNotNull(cartItem.getCartItemId());
        String url = Base_URL + "/read/" + cartItem.getCartItemId();
        System.out.println("URL: " + url);
        ResponseEntity<CartItem> response = restTemplate.getForEntity(url, CartItem.class);
        cartItem = response.getBody();
        assertNotNull(response.getBody());
        assertEquals(cartItem.getCartItemId(), response.getBody().getCartItemId());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    @Order(3)
    void update() {
        assertNotNull(cartItem.getCartItemId());
        String url = Base_URL + "/update";
        CartItem newCartItem = new CartItem.Builder().copy(cartItem)
                .setQuantity(2)
                .build();
        ResponseEntity<CartItem> postResponse = restTemplate.postForEntity(url, newCartItem, CartItem.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        CartItem cartItemUpdated = postResponse.getBody();
        assertEquals(newCartItem.getCartItemId(), cartItemUpdated.getCartItemId());
        assertEquals(2, cartItemUpdated.getQuantity());
        System.out.println("Updated data: " + cartItemUpdated);
    }

    @Test
    @Order(4)
    void delete() {
        assertNotNull(cartItem.getCartId());
        String url = Base_URL + "/delete/" + cartItem.getCartId();
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
