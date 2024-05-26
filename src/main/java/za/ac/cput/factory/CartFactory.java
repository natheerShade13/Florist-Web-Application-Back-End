package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.utility.CartHelper;

import java.time.LocalDate;

public class CartFactory {
    public static Cart createCart(Customer customer, LocalDate createdDate) {
        if ( customer == null  || createdDate == null) {
            return null;
        }
        long cartId = CartHelper.generateUniqueID();

        return new Cart.Builder()
                .setcartId(cartId)
                //.setCustomer(customer)
                .setCreatedDate(createdDate)
                .build();
    }
}
