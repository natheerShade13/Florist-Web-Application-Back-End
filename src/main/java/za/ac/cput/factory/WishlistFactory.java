package za.ac.cput.factory;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Wishlist;
import za.ac.cput.util.WishlistHelper;

import java.time.LocalDate;

public class WishlistFactory {
    public static Wishlist buildWishlist(long wishlistId, LocalDate dateCreated, Customer customer) {
        if (WishlistHelper.validId(wishlistId) || WishlistHelper.isNull(dateCreated) || customer == null) {
            return null;
        }

        return new Wishlist.Builder().setWishListId(wishlistId).setDateCreated(dateCreated).setCustomer(customer)
                .build();
    }
}
