package za.ac.cput.api;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartProduct;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.ProductFactory;
import za.ac.cput.repository.CartRepository;
import za.ac.cput.repository.ProductRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerCartTest {

    @Autowired
    private CustomerCart customerCart;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    private static Cart cart;
    private static Product product;
    private static Customer customer;

    @BeforeEach
    void setUp() {
        customer = CustomerFactory.buildCustomer(
                "Jake", "Long", "jake.long@gmail.com", "jakeLong", "0677784626", LocalDate.of(2000, Month.JANUARY, 1));
        cart = CartFactory.buildCart(customer);
        cartRepository.save(cart);

        product = ProductFactory.buildProduct(
                "Jalapeno", "Red hot jalapeno", 50,
                "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=", 5, "Plant");
        productRepository.save(product);
    }

    @AfterEach
    void tearDown() {
        cartRepository.deleteAll();
        productRepository.deleteAll();
    }

    @Test
    @Order(1)
    void testGetCartProducts() {
        List<CartProduct> cartProducts = customerCart.getCartProducts(cart.getCartId());
        assertNotNull(cartProducts, "Cart products list should not be null");
        assertTrue(cartProducts.isEmpty(), "Cart should be empty initially");
    }

    @Test
    @Order(2)
    void testAddProductToCart() {
        CartProduct cartProduct = customerCart.addProductToCart(cart.getCartId(), product.getProductId());
        assertNotNull(cartProduct, "Cart product should not be null");
        assertEquals(1, cartProduct.getQuantity(), "Quantity should be 1 after adding product");
        assertEquals(product.getPrice(), cartProduct.getUnitPrice(), "Unit price should match the product price");

        List<CartProduct> cartProducts = customerCart.getCartProducts(cart.getCartId());
        assertEquals(1, cartProducts.size(), "Cart should contain 1 product");
        assertEquals(product.getProductId(), cartProducts.get(0).getProduct().getProductId(), "Product ID should match");
    }

    @Test
    @Order(3)
    void testRemoveProductFromCart() {
        customerCart.addProductToCart(cart.getCartId(), product.getProductId());
        boolean result = customerCart.removeProductFromCart(cart.getCartId(), product.getProductId());
        assertTrue(result, "Product should be removed successfully");

        List<CartProduct> cartProducts = customerCart.getCartProducts(cart.getCartId());
        assertTrue(cartProducts.isEmpty(), "Cart should be empty after removal");
    }

    @Test
    void testRemoveProductFromEmptyCart() {
        boolean result = customerCart.removeProductFromCart(cart.getCartId(), product.getProductId());
        assertFalse(result, "Removing a product from an empty cart should return false");
    }
}
