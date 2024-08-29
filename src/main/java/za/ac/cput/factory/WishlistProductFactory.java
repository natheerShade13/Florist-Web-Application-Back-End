package za.ac.cput.factory;

import za.ac.cput.domain.Product;
import za.ac.cput.domain.Wishlist;
import za.ac.cput.domain.WishlistProduct;
import za.ac.cput.util.WishlistProductHelper;

public class WishlistProductFactory {
    public static WishlistProduct buildWishlistProduct(Wishlist wishlist, Product product) {
        if (wishlist == null || product == null) {
            return null;
        }

        return new WishlistProduct.Builder().setWishlist(wishlist).setProduct(product).build();
    }
}
