package za.ac.cput.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
public class CartItemFactoryTest {

    private CartItem cartItem1;
    private CartItem cartItem2;
    @Test
    @Order(1)
    void createValidCartItem() {
        Cart cart = new Cart();
        Product product = new Product();
        cartItem1 = CartItemFactory.createCartItem(cart, product, 3, 29.99);
        assertNotNull(cartItem1);
        System.out.println("******* valid cart item *******");
        Assertions.assertEquals(cart, cartItem1.getCartId());
        Assertions.assertEquals(product, cartItem1.getProductId());
        Assertions.assertEquals(3,cartItem1.getQuantity());
        Assertions.assertEquals(29.99,cartItem1.getPrice());
        System.out.println(cartItem1);
    }

    @Test
    @Order(2)
    void createCartItemWithInvalidQuantity() {
        Cart cartb = new Cart();
        Product productb = new Product();
        cartItem2 = CartItemFactory.createCartItem(cartb, productb, -3, 29.99);
        Assertions.assertNull(cartItem2);
        System.out.println("***** InvalidQuantity *****");
    }

}
