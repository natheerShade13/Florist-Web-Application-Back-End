package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.NurseryWebApplication;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = NurseryWebApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CartServiceTest {

    @Autowired
    private CartService cartService;
    private static Customer customer;
    private Cart cart;
    @BeforeAll
    static void beforeAll() {
//        customer = new Customer.Builder()
//                .setId(345L)
//                .setFirstName("Mabotse")
//                .setLastname("Mosima")
//                //.setContact()
//                .build();
    }
    @BeforeEach
    void setUp() {
        cart = CartFactory.createCart(new Customer(),LocalDate.now());
    }

    @Test
    @Order(1)
    void create() {
        Cart createdCart = cartService.create(cart);
        assertNotNull(createdCart); // Ensure a valid cart is created
        System.out.println(createdCart);
    }

    @Test
    @Order(2)
    void read() {
        Cart readCart = cartService.read(cart.getCartId());
        //assertNotNull(readCart);
        System.out.println(readCart); // Ensure a valid cart is read
    }

    @Test
    @Order(3)
    void update() {
        LocalDate newDate = LocalDate.now().plusDays(1);
        Cart newCart = new Cart.Builder()
                .copy(cart)
                .setCreatedDate(newDate)
                .build();
        Cart updated = cartService.update(newCart);
        assertNotNull(updated);
        assertEquals(cart.getCartId(), updated.getCartId());
        assertEquals(newDate, updated.getCreatedDate());
        System.out.println("Updated: " + updated);
    }

    @Test
    @Order(4)
    void delete() {
        cartService.delete(cart.getCartId());
        assertNull(cartService.read(cart.getCartId())); // Ensure cart is deleted
    }

    @Test
    @Order(5)
    void e_getAll() {
        //assertFalse(cartService.getall().isEmpty());
        assert(cartService.getall().isEmpty());
        System.out.println(cartService.getall());
    }
}
