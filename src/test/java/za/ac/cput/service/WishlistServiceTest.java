package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Wishlist;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.WishlistFactory;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class WishlistServiceTest {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private WishlistService wishlistService;

    private static Customer customer;
    private static Wishlist wishlist;

    @Test
    @Order(0)
    void setUp() {
        customer = CustomerFactory.buildCustomer(1, "Jake", "Long"
                , "jake.long@gmail.com", "jakeLong", "0677784626"
                , LocalDate.of(2000, Month.JANUARY, 1));
        //wishlist = WishlistFactory.buildWishlist(customer);
    }

    @Test
    @Order(1)
    void create() {
        Customer createCustomer = customerService.create(customer);
        assertNotNull(createCustomer);
        wishlist = WishlistFactory.buildWishlist(createCustomer);
        wishlist = wishlistService.create(wishlist);
        assertNotNull(wishlist);
        System.out.println(wishlist);
    }

    @Test
    @Order(2)
    void read() {
        Wishlist findWishlist = wishlistService.read(wishlist.getWishListId());
        assertNotNull(findWishlist);
        System.out.println(findWishlist);
    }

    @Test
    @Order(3)
    void update() {
        Wishlist newWishlist = new Wishlist.Builder().copy(wishlist).setDateCreated(LocalDate.now()).build();
        assertNotNull(newWishlist);
        Wishlist updateWishlist = wishlistService.update(newWishlist);
        assertNotNull(updateWishlist);
        System.out.println(updateWishlist);
    }

    @Test
    @Order(5)
    void delete() {
        boolean deleteWishlist = wishlistService.delete(wishlist.getWishListId());
        assertTrue(deleteWishlist);
        System.out.println(deleteWishlist);
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(wishlistService.getAll());
    }
}