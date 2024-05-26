package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.domain.Product;
import za.ac.cput.utility.CartItemHelper;

public class CartItemFactory {

    public static CartItem createCartItem(Cart cart, Product product, int quantity, double price) {
        if (cart == null || product == null
                || !CartItemHelper.isValidQuantity(quantity) || !CartItemHelper.isValidPrice(price)) {
            return null;
        }

        long cartItemId = CartItemHelper.generateUniqueID();

        return new CartItem.Builder()
                .setCartItemId(cartItemId)
                //.setcart(cart)
                //.setProduct(product)
                .setQuantity(quantity)
                .setPrice(price)
                .build();
    }
}
