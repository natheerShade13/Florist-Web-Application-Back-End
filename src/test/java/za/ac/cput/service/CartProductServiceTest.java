package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartProduct;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.factory.CartProductFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.ProductFactory;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
class CartProductServiceTest {

    @Autowired
    private CartProductService cartProductService;

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    private Customer customer;
    private Cart cart;
    private Product product;
    private CartProduct cartProduct;

    @BeforeEach
    void setUp() {
        String uniqueEmail = "jake.long" + System.currentTimeMillis() + "@gmail.com";
        customer = CustomerFactory.buildCustomer("Jake", "Long",
                uniqueEmail, "jakeLong", "0677784626",
                LocalDate.of(2000, Month.JANUARY, 1));
        customer = customerService.create(customer);
        assertNotNull(customer, "Customer creation failed");

        cart = CartFactory.buildCart(customer);
        cart = cartService.create(cart);
        assertNotNull(cart, "Cart creation failed");

        product = ProductFactory.buildProduct("jalapino", "red hot jalapeno", 50, "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=", 5, "Plant");
        product = productService.create(product);
        assertNotNull(product, "Product creation failed");

        cartProduct = CartProductFactory.buildCartProduct(cart, product, 2, 100.0);
    }

    @Test
    @Order(1)
    void create() {
        CartProduct createdCartProduct = cartProductService.create(cartProduct);
        assertNotNull(createdCartProduct, "Failed to create CartProduct");
        assertEquals(cart, createdCartProduct.getCart());
        assertEquals(product, createdCartProduct.getProduct());
        assertEquals(200.0, createdCartProduct.getTotalPrice(), "Total price should be 200.0");
        System.out.println("Created CartProduct: " + createdCartProduct);
    }

    @Test
    @Order(2)
    void read() {
        CartProduct createdCartProduct = cartProductService.create(cartProduct);
        CartProduct foundCartProduct = cartProductService.read(createdCartProduct.getCartProductId());
        assertNotNull(foundCartProduct, "CartProduct should be found");
        assertEquals(createdCartProduct.getCartProductId(), foundCartProduct.getCartProductId());
        assertEquals(createdCartProduct.getCart(), foundCartProduct.getCart());
        assertEquals(200.0, foundCartProduct.getTotalPrice(), "Total price should be 200.0");
        System.out.println("Read CartProduct: " + foundCartProduct);
    }

    @Test
    @Order(3)
    void update() {
        CartProduct createdCartProduct = cartProductService.create(cartProduct);
        assertNotNull(createdCartProduct, "Failed to create CartProduct");

        int newQuantity = 5;
        double newTotalPrice = newQuantity * createdCartProduct.getUnitPrice();
        CartProduct updatedCartProduct = new CartProduct.Builder()
                .copy(createdCartProduct)
                .setQuantity(newQuantity)
                .setTotalPrice(newTotalPrice)
                .build();

        CartProduct result = cartProductService.update(updatedCartProduct);
        assertNotNull(result, "Failed to update CartProduct");
        assertEquals(newQuantity, result.getQuantity(), "CartProduct quantity should be updated");
        assertEquals(newTotalPrice, result.getTotalPrice(), "Total price should be updated");

        CartProduct updatedCartProductFromDB = cartProductService.read(createdCartProduct.getCartProductId());
        assertEquals(newQuantity, updatedCartProductFromDB.getQuantity(), "CartProduct quantity should be updated in the DB");
        assertEquals(newTotalPrice, updatedCartProductFromDB.getTotalPrice(), "Total price should be updated in the DB");
        assertEquals(createdCartProduct.getCartProductId(), updatedCartProductFromDB.getCartProductId(), "CartProduct ID should not change on update");

        System.out.println("Updated CartProduct: " + result);
    }

    @Test
    @Order(4)
    void getAll() {
        // Clear existing CartProducts
        List<CartProduct> existingCartProducts = cartProductService.getAll();
        System.out.println("Existing CartProducts before test: " + existingCartProducts);

        for (CartProduct existingCartProduct : existingCartProducts) {
            boolean deleted = cartProductService.delete(existingCartProduct.getCartProductId());
            System.out.println("Deleted CartProduct ID: " + existingCartProduct.getCartProductId() + ", success: " + deleted);
        }

        // Create new CartProducts
        CartProduct createdCartProduct = cartProductService.create(cartProduct);
        assertNotNull(createdCartProduct, "Failed to create CartProduct");

        CartProduct cartProduct2 = CartProductFactory.buildCartProduct(cart, product, 3, 150.0);
        CartProduct createdCartProduct2 = cartProductService.create(cartProduct2);

        List<CartProduct> allCartProducts = cartProductService.getAll();
        System.out.println("All CartProducts after creation: " + allCartProducts);

        assertFalse(allCartProducts.isEmpty(), "CartProduct list should not be empty");
        assertEquals(2, allCartProducts.size(), "CartProduct list should contain 2 CartProducts");
        assertTrue(allCartProducts.stream().anyMatch(cp -> cp.getCartProductId() == createdCartProduct.getCartProductId()),
                "CartProduct list should contain the first created CartProduct");
        assertTrue(allCartProducts.stream().anyMatch(cp -> cp.getCartProductId() == createdCartProduct2.getCartProductId()),
                "CartProduct list should contain the second created CartProduct");
    }

    @Test
    @Order(5)
    void delete() {
        CartProduct createdCartProduct = cartProductService.create(cartProduct);
        assertNotNull(createdCartProduct, "Failed to create CartProduct");

        boolean deleted = cartProductService.delete(createdCartProduct.getCartProductId());
        assertTrue(deleted, "Failed to delete CartProduct");

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            cartProductService.read(createdCartProduct.getCartProductId());
        });
        assertEquals("CartProduct with ID " + createdCartProduct.getCartProductId() + " does not exist", exception.getMessage());

        List<CartProduct> allCartProducts = cartProductService.getAll();
        assertTrue(allCartProducts.stream().noneMatch(cp -> cp.getCartProductId() == createdCartProduct.getCartProductId()),
                "Deleted CartProduct should not be present in getAll() result");

        System.out.println("Deleted CartProduct with ID: " + createdCartProduct.getCartProductId());
    }
}