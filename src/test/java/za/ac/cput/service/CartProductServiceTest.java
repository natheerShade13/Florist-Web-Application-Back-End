package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CartProductServiceTest {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CartProductService cartProductService;

    private static Customer customer;
    private static Cart cart;
    private static Product product;
    private static CartProduct cartProduct;

    @Test
    @Order(0)
    void setUp() {
        customer = CustomerFactory.buildCustomer("Jake", "Long"
                , "jake.long@gmail.com", "jakeLong", "0677784626"
                , LocalDate.of(2000, Month.JANUARY, 1));
        cart = CartFactory.buildCart(customer);
        String imageUrl = "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=";
        product = ProductFactory.buildProduct(1, "Jalapeno", "Red hot jalapeno"
                , 50, imageUrl, 5, "Plant");
        cartProduct = CartProductFactory.buildCartProduct(1, cart, product, 5, 50);
    }

    @Test
    @Order(1)
    void create() {
        Customer createCustomer = customerService.create(customer);
        assertNotNull(createCustomer);
        System.out.println(createCustomer);
        //cart = CartFactory.buildCart(createCustomer);
        Cart newCart = cartService.create(cart);
        assertNotNull(newCart);
        System.out.println(newCart);
        Product createProduct = productService.create(product);
        assertNotNull(createProduct);
        System.out.println(createProduct);
        //cartProduct = CartProductFactory.buildCartProduct(1, cart, createProduct, 5, 50);
        CartProduct createCartProduct = cartProductService.create(cartProduct);
        assertNotNull(createCartProduct);
        System.out.println(createCartProduct);
    }

    @Test
    @Order(2)
    void read() {
        CartProduct findCartProduct = cartProductService.read(cartProduct.getCartProductId());
        assertNotNull(findCartProduct);
        System.out.println(cartProduct);
    }

    @Test
    @Order(3)
    void update() {
        CartProduct newCartProduct = new CartProduct.Builder().copy(cartProduct).setQuantity(2).build();
        assertNotNull(newCartProduct);
        CartProduct updatedCartProduct = cartProductService.update(newCartProduct);
        assertNotNull(updatedCartProduct);
        System.out.println(updatedCartProduct);
    }

    @Test
    @Order(5)
    //@Disabled
    void delete() {
        boolean deleteCartProduct = cartProductService.delete(cartProduct.getCartProductId());
        assertTrue(deleteCartProduct);
        System.out.println(deleteCartProduct);
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(cartProductService.getAll());
    }
}