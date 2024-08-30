package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.factory.CustomerFactory;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
class CartServiceTest {

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerService customerService;

    private Customer customer;
    private Cart cart;

    @BeforeEach
    void setUp() {
        String uniqueEmail = "jake.long" + System.currentTimeMillis() + "jake.long@gmail.com";
        customer = CustomerFactory.buildCustomer("Jake", "Long",
                uniqueEmail, "jakeLong", "0677784626",
                LocalDate.of(2000, Month.JANUARY, 1));
        customer = customerService.create(customer);
        assertNotNull(customer, "Customer creation failed");

        cart = CartFactory.buildCart(customer);
    }

    @Test
    @Order(1)
    void create() {
        Cart createdCart = cartService.create(cart);
        assertNotNull(createdCart, "Failed to create Cart");
        assertEquals(customer, createdCart.getCustomer());
        assertNotNull(createdCart.getDateCreated());
        System.out.println("Created Cart: " + createdCart);
    }

    @Test
    @Order(2)
    void read() {
        Cart createdCart = cartService.create(cart);
        Cart foundCart = cartService.read(createdCart.getCartId());
        assertNotNull(foundCart, "Cart should be found");
        assertEquals(createdCart.getCartId(), foundCart.getCartId());
        assertEquals(createdCart.getCustomer(), foundCart.getCustomer());
        System.out.println("Read Cart: " + foundCart);
    }

    @Test
    @Order(3)
    void update() {
        Cart createdCart = cartService.create(cart);
        assertNotNull(createdCart, "Failed to create Cart");

        LocalDate newDate = LocalDate.now().plusDays(1);
        Cart updatedCart = new Cart.Builder()
                .copy(createdCart)
                .setDateCreated(newDate)
                .build();

        Cart result = cartService.update(updatedCart);
        assertNotNull(result, "Failed to update Cart");
        assertEquals(newDate, result.getDateCreated(), "Cart date should be updated");

        Cart updatedCartFromDB = cartService.read(createdCart.getCartId());
        assertEquals(newDate, updatedCartFromDB.getDateCreated(), "Cart date should be updated in the DB");
        assertEquals(createdCart.getCartId(), updatedCartFromDB.getCartId(), "Cart ID should not change on update");

        System.out.println("Updated Cart: " + result);
    }

    @Test
    @Order(4)
    void getAll() {
        // Clear existing carts
        List<Cart> existingCarts = cartService.getAll();
        System.out.println("Existing carts before test: " + existingCarts);

        for (Cart existingCart : existingCarts) {
            boolean deleted = cartService.delete(existingCart.getCartId());
            System.out.println("Deleted cart ID: " + existingCart.getCartId() + ", success: " + deleted);
        }

        // Create a new cart
        Cart createdCart = cartService.create(cart);
        assertNotNull(createdCart, "Failed to create Cart");

        // Create another cart with a different customer
        String uniqueEmail2 = "jane.doe" + System.currentTimeMillis() + "@gmail.com";
        Customer customer2 = CustomerFactory.buildCustomer("Jane", "Doe",
                uniqueEmail2, "janeDoe", "0123456789",
                LocalDate.of(2001, Month.FEBRUARY, 2));
        customer2 = customerService.create(customer2);
        Cart cart2 = CartFactory.buildCart(customer2);
        Cart createdCart2 = cartService.create(cart2);

        List<Cart> allCarts = cartService.getAll();
        System.out.println("All carts after creation: " + allCarts);

        assertFalse(allCarts.isEmpty(), "Cart list should not be empty");
        assertEquals(2, allCarts.size(), "Cart list should contain 2 carts");
        assertTrue(allCarts.stream().anyMatch(c -> c.getCartId() == createdCart.getCartId()),
                "Cart list should contain the first created Cart");
        assertTrue(allCarts.stream().anyMatch(c -> c.getCartId() == createdCart2.getCartId()),
                "Cart list should contain the second created Cart");
    }

    @Test
    @Order(5)
    void delete() {
        Cart createdCart = cartService.create(cart);
        assertNotNull(createdCart, "Failed to create Cart");

        boolean deleted = cartService.delete(createdCart.getCartId());
        assertTrue(deleted, "Failed to delete Cart");

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            cartService.read(createdCart.getCartId());
        });
        assertEquals("Cart with ID " + createdCart.getCartId() + " does not exist", exception.getMessage());

        List<Cart> allCarts = cartService.getAll();
        assertTrue(allCarts.stream().noneMatch(c -> c.getCartId() == createdCart.getCartId()),
                "Deleted Cart should not be present in getAll() result");

        System.out.println("Deleted Cart with ID: " + createdCart.getCartId());
    }

    @Test
    @Order(6)
    void findByCustomerId() {
        Cart createdCart = cartService.create(cart);
        Cart foundCart = cartService.findByCustomerId(customer.getCustomerId());
        assertNotNull(foundCart, "Cart should be found by customer ID");
        assertEquals(createdCart.getCartId(), foundCart.getCartId(), "Cart ID should match");
        assertEquals(customer, foundCart.getCustomer(), "Cart customer should match");
        System.out.println("Found Cart by Customer ID: " + foundCart);
    }
}