package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

public class CartFactoryTest {

    private Customer customer;

    @Test
    public void testBuildCartWithValidCustomer() {
        customer = CustomerFactory.buildCustomer(
                "Jake", "Long",
                "jake.long@gmail.com", "jakeLong", "0677784626",
                LocalDate.of(2000, Month.JANUARY, 1)
        );
        Cart cart = CartFactory.buildCart(customer);

        assertNotNull(cart, "Cart should not be null");
        assertEquals(customer, cart.getCustomer(), "Customer in the cart should match the provided customer");
        assertNotNull(cart.getDateCreated(), "Cart creation date should not be null");
        assertTrue(cart.getDateCreated().isBefore(LocalDate.now().plusDays(1)), "Cart creation date should be within a reasonable range");
    }

    @Test
    public void testBuildCartWithNullCustomer() {
        Cart cart = CartFactory.buildCart(null);

        assertNull(cart, "Cart should be null when the customer is null");
    }

    @Test
    public void testBuildCartWithEmptyCustomerFields() {
        customer = CustomerFactory.buildCustomer(
                "", "", "", "", "", LocalDate.of(2000, Month.JANUARY, 1)
        );
        Cart cart = CartFactory.buildCart(customer);

        assertNotNull(cart, "Cart should not be null even if customer fields are empty");
        assertEquals(customer, cart.getCustomer(), "Customer in the cart should match the provided customer");
    }
}
