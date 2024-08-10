package za.ac.cput.factory;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Wishlist;
import za.ac.cput.util.WishlistHelper;

import java.time.LocalDate;

public class WishlistFactory {
    public static Wishlist buildWishlist(Customer customer) { //long wishlistId, LocalDate dateCreated,
        if (customer == null) { //WishlistHelper.validId(wishlistId) || WishlistHelper.isNull(dateCreated) ||
            return null;
        }

        return new Wishlist.Builder().setDateCreated(LocalDate.now()).setCustomer(customer) //.setWishListId(wishlistId)
                .build();
    }
}
