package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Wishlist;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class WishlistFactoryTest {

    private Customer customer;
    private Wishlist wishlistA;
    private Wishlist wishlistB;

    @Test
    void buildWishlist() {
        customer = CustomerFactory.buildCustomer(1, "Jake", "Long"
                , "jake.long@gmail.com", "jakeLong", "0677784626"
                , LocalDate.of(2000, Month.JANUARY, 1));
        wishlistA = WishlistFactory.buildWishlist(customer);
        assertNotNull(wishlistA);
        System.out.println(wishlistA);
    }

    @Test
    void buildWishlistFail() {
        Customer customerA = null;
        wishlistB = WishlistFactory.buildWishlist(customerA);
        assertNotNull(wishlistB);
        System.out.println(wishlistB);
    }

}