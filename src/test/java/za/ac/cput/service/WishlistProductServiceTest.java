package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Wishlist;
import za.ac.cput.domain.WishlistProduct;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.ProductFactory;
import za.ac.cput.factory.WishlistFactory;
import za.ac.cput.factory.WishlistProductFactory;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class WishlistProductServiceTest {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private WishlistService wishlistService;
    @Autowired
    private ProductService productService;
    @Autowired
    private  WishlistProductService wishlistProductService;

    private static Customer customer;
    private static Wishlist wishlist;
    private static Product product;
    private static WishlistProduct wishlistProduct;

    @Test
    @Order(0)
    void setUp() {
        customer = CustomerFactory.buildCustomer(1, "Jake", "Long"
                , "jake.long@gmail.com", "jakeLong", "0677784626"
                , LocalDate.of(2000, Month.JANUARY, 1));
        //wishlist = WishlistFactory.buildWishlist(customer);
        String imageUrl = "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=";
        product = ProductFactory.buildProduct( "Jalapeno", "Red hot jalapeno"
                , 50, imageUrl, 5, "Plant");
        //wishlistProduct = WishlistProductFactory.buildWishlistProduct(1, wishlist, product);
    }

    @Test
    @Order(1)
    void create() {
        Customer createCustomer = customerService.create(customer);
        assertNotNull(createCustomer);
        wishlist = WishlistFactory.buildWishlist(createCustomer);
        wishlist = wishlistService.create(wishlist);
        assertNotNull(wishlist);
        Product createProduct = productService.create(product);
        assertNotNull(createProduct);
        wishlistProduct = WishlistProductFactory.buildWishlistProduct(1, wishlist, createProduct);
        wishlistProduct = wishlistProductService.create(wishlistProduct);
        assertNotNull(wishlistProduct);
        System.out.println(wishlistProduct);
    }

    @Test
    @Order(2)
    void read() {
        WishlistProduct findWishlistProduct = wishlistProductService.read(wishlistProduct.getWishlistProductId());
        assertNotNull(findWishlistProduct);
        System.out.println(findWishlistProduct);
    }

    @Test
    @Order(3)
    void update() {
        WishlistProduct newWishlistProduct = new WishlistProduct.Builder().copy(wishlistProduct).setWishlistProductId(1).build();
        assertNotNull(newWishlistProduct);
        WishlistProduct updateWishlistProduct = wishlistProductService.update(newWishlistProduct);
        assertNotNull(updateWishlistProduct);
        System.out.println(updateWishlistProduct);
    }

    @Test
    @Order(5)
    void delete() {
        boolean delete = wishlistProductService.delete(wishlistProduct.getWishlistProductId());
        assertTrue(delete);
        System.out.println(delete);
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(wishlistProductService.getAll());
    }
}