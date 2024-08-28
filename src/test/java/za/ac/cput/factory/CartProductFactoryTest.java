package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class CartProductFactoryTest {

    private Customer customer;
    private Cart cart;
    private Product product;
    private CartProduct cartProductA;
    private CartProduct cartProductB;

    @Test
    void buildCartProduct() {
        customer = CustomerFactory.buildCustomer("Jake", "Long"
                , "jake.long@gmail.com", "jakeLong", "0677784626"
                , LocalDate.of(2000, Month.JANUARY, 1));
        cart = CartFactory.buildCart(customer);
        String imageUrl = "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=";
        product = ProductFactory.buildProduct( "Jalapeno", "Red hot jalapeno"
                , 50, imageUrl, 5, "Plant");
        cartProductA = CartProductFactory.buildCartProduct(cart, product, 5, 50);

        // Test if cartProductA is not null
        assertNotNull(cartProductA);

        // Test if total price is calculated correctly (quantity * unitPrice)
        assertEquals(250, cartProductA.getTotalPrice());

        System.out.println(cartProductA);
    }

    @Test
    void buildCartProductFail() {
        customer = CustomerFactory.buildCustomer("Jake", "Long"
                , "jake.long@gmail.com", "jakeLong", "0677784626"
                , LocalDate.of(2000, Month.JANUARY, 1));
        cart = CartFactory.buildCart(customer);
        String imageUrl = "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=";
        product = ProductFactory.buildProduct( "Jalapeno", "Red hot jalapeno"
                , 50, imageUrl, 5, "Plant");
        cartProductB = CartProductFactory.buildCartProduct(cart, product, -1, 50);

        // Test if cartProductB is null due to invalid quantity
        assertNull(cartProductB);
        System.out.println(cartProductB);
    }
}
