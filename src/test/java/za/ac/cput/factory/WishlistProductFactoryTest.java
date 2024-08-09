package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Wishlist;
import za.ac.cput.domain.WishlistProduct;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class WishlistProductFactoryTest {

    private Customer customer;
    private Wishlist wishlist;
    private Product product;
    private WishlistProduct wishlistProductA;
    private WishlistProduct wishlistProductB;

    @Test
    void buildWishlistProduct() {
        customer = CustomerFactory.buildCustomer(1, "Jake", "Long"
                , "jake.long@gmail.com", "jakeLong", "0677784626"
                , LocalDate.of(2000, Month.JANUARY, 1));
        wishlist = WishlistFactory.buildWishlist(1, LocalDate.now(), customer);
        String imageUrl = "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=";
        product = ProductFactory.buildProduct(1, "Jalapeno", "Red hot jalapeno"
                , 50, imageUrl, 5, "Plant");
        wishlistProductA = WishlistProductFactory.buildWishlistProduct(1, wishlist, product);
        assertNotNull(wishlistProductA);
        System.out.println(wishlistProductA);
    }

    @Test
    void buildWishlistProductFail() {
        customer = CustomerFactory.buildCustomer(1, "Jake", "Long"
                , "jake.long@gmail.com", "jakeLong", "0677784626"
                , LocalDate.of(2000, Month.JANUARY, 1));
        wishlist = WishlistFactory.buildWishlist(1, LocalDate.now(), customer);
        String imageUrl = "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=";
        product = ProductFactory.buildProduct(1, "Jalapeno", "Red hot jalapeno"
                , 50, imageUrl, 5, "Plant");
        wishlistProductB = WishlistProductFactory.buildWishlistProduct(1, wishlist = null, product);
        assertNotNull(wishlistProductB);
        System.out.println(wishlistProductB);
    }
}