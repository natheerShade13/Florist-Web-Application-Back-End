package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.util.CartHelper;

public class CartFactory {

    public static Cart buildCart(long cartId, Customer customer){
        if (CartHelper.validId(cartId) || customer == null){
            return null;
        }

        return new Cart.Builder().setCartId(cartId).setCustomer(customer).build();

    }

}
