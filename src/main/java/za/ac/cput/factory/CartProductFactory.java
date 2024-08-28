package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartProduct;
import za.ac.cput.domain.Product;
import za.ac.cput.util.CartProductHelper;

public class CartProductFactory {

    public static CartProduct buildCartProduct(Cart cart, Product product, int quantity, double unitPrice) {
        // Validation checks to ensure valid inputs
        if (cart == null || product == null ||
                CartProductHelper.isLessThanZero(quantity) ||
                CartProductHelper.isNegative(unitPrice)) {
            return null;
        }

        // Calculate total price
        double totalPrice = quantity * unitPrice;

        // Create CartProduct using the Builder pattern
        return new CartProduct.Builder()
                .setCart(cart)
                .setProduct(product)
                .setQuantity(quantity)
                .setUnitPrice(unitPrice)
                .setTotalPrice(totalPrice)  // Set the calculated total price
                .build();
    }
}