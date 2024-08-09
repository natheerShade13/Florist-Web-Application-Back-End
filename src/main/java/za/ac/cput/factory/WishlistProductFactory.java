package za.ac.cput.factory;

import za.ac.cput.domain.Product;
import za.ac.cput.domain.Wishlist;
import za.ac.cput.domain.WishlistProduct;
import za.ac.cput.util.WishlistProductHelper;

public class WishlistProductFactory {
    public static WishlistProduct buildWishlistProduct(long wishlistProductId, Wishlist wishlist, Product product) {
        if (WishlistProductHelper.validId(wishlistProductId) || wishlist == null || product == null) {
            return null;
        }

        return new WishlistProduct.Builder().setWishlistProductId(wishlistProductId).setWishlist(wishlist).setProduct(product)
                .build();
    }
}
