package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class CartFactoryTest {

    private Customer customer;
    private Cart cartA;
    private Cart cartB;

    @Test
    void buildCart() {
        customer = CustomerFactory.buildCustomer(1, "Jake", "Long"
                , "jake.long@gmail.com", "jakeLong", "0677784626"
                , LocalDate.of(2000, Month.JANUARY, 1));
        cartA = CartFactory.buildCart(customer);
        assertNotNull(cartA);
        System.out.println(cartA);
    }

    @Test
    void buildCartFail() {
        Customer customerB = null;
        cartB = CartFactory.buildCart(customerB);
        assertNotNull(cartB);
        System.out.println(cartB);
    }

}