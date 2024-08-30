package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartProduct;
import za.ac.cput.domain.Product;

public class CartProductFactory {

    public static CartProduct buildCartProduct(Cart cart, Product product, int quantity, double unitPrice) {
        double totalPrice = quantity * unitPrice;
        return new CartProduct.Builder()
                .setCart(cart)
                .setProduct(product)
                .setQuantity(quantity)
                .setUnitPrice(unitPrice)
                .setTotalPrice(totalPrice)
                .build();
    }
}