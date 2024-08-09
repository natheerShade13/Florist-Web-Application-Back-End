package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartProduct;
import za.ac.cput.domain.Product;
import za.ac.cput.util.CartProductHelper;

public class CartProductFactory {

    public static CartProduct buildCartProduct(long cartProductId, Cart cart, Product product, int quantity
            , double unitPrice){
        if (CartProductHelper.validId(cartProductId) || cart == null || product == null
                || CartProductHelper.isLessThanZero(quantity) || CartProductHelper.isNegative(unitPrice)){
            return null;
        }

        return new CartProduct.Builder().setCartProductId(cartProductId).setCart(cart).setProduct(product)
                .setQuantity(quantity).setUnitPrice(unitPrice).build();
    }
}
