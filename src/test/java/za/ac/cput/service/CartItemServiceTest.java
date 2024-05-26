package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.CartItem;
import za.ac.cput.factory.CartItemFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CartItemServiceTest {

    @Autowired
    private CartItemService cartItemService;
    static Cart cart = new Cart();
    static Product product = new Product();
    private CartItem cartItem = CartItemFactory.createCartItem(cart,product,3,33.99);

    @Test
    @Order(1)
    void b_create() {
        CartItem created = cartItemService.create(cartItem);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void c_read() {
        CartItem read = cartItemService.read(cartItem.getCartItemId());
        System.out.println(read);
    }

    @Test
    void d_update() {
        CartItem newCartItem = new CartItem.Builder()
                .copy(cartItem)
                .setQuantity(5)
                .build();
        CartItem update = cartItemService.update(newCartItem);
        assertNotNull(update);
        assertEquals(5, update.getQuantity());
        System.out.println(update);
    }

    @Test
    void e_getAll() {
        assert(cartItemService.getAll().isEmpty());
        System.out.println(cartItemService.getAll());
    }
}
