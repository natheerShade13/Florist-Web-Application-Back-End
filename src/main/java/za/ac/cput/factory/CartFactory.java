package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.util.CartHelper;

import java.time.LocalDate;

public class CartFactory {

    public static Cart buildCart(Customer customer) {
        if (customer == null) {
            return null;
        }

        return new Cart.Builder()
                .setDateCreated(LocalDate.now())
                .setCustomer(customer)
                .build();
    }
}