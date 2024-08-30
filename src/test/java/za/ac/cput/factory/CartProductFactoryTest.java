package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartProduct;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

public class CartProductFactoryTest {
    private Customer customer;
    private Product product;
    private Cart cart;

    @Test
    public void testCreateCartProductWithValidInput() {
        customer = CustomerFactory.buildCustomer("Jake", "Long",
                "jake.long@gmail.com", "jakeLong", "0677784626",
                LocalDate.of(2000, Month.JANUARY, 1));
        cart = CartFactory.buildCart(customer);
        String imageUrl = "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=";
        product = ProductFactory.buildProduct("Jalapeno", "Red hot jalapeno",
                50, imageUrl, 5, "Plant");
        int quantity = 5;
        double unitPrice = 10.0;

        CartProduct cartProduct = CartProductFactory.buildCartProduct(cart, product, quantity, unitPrice);

        assertNotNull(cartProduct, "CartProduct should not be null");
        assertEquals(cart, cartProduct.getCart(), "Cart should match the provided cart");
        assertEquals(product, cartProduct.getProduct(), "Product should match the provided product");
        assertEquals(quantity, cartProduct.getQuantity(), "Quantity should match the provided quantity");
        assertEquals(unitPrice, cartProduct.getUnitPrice(), "Unit price should match the provided unit price");
    }

    @Test
    public void testCreateCartProductWithZeroQuantity() {
        customer = CustomerFactory.buildCustomer("Jake", "Long",
                "jake.long@gmail.com", "jakeLong", "0677784626",
                LocalDate.of(2000, Month.JANUARY, 1));
        cart = CartFactory.buildCart(customer);
        String imageUrl = "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=";
        product = ProductFactory.buildProduct("Jalapeno", "Red hot jalapeno",
                50, imageUrl, 5, "Plant");
        int quantity = 0;
        double unitPrice = 10.0;

        CartProduct cartProduct = CartProductFactory.buildCartProduct(cart, product, quantity, unitPrice);

        assertNotNull(cartProduct, "CartProduct should not be null");
        assertEquals(cart, cartProduct.getCart(), "Cart should match the provided cart");
        assertEquals(product, cartProduct.getProduct(), "Product should match the provided product");
        assertEquals(quantity, cartProduct.getQuantity(), "Quantity should match the provided quantity");
        assertEquals(unitPrice, cartProduct.getUnitPrice(), "Unit price should match the provided unit price");
    }

    @Test
    public void testCreateCartProductWithNegativeQuantity() {
        customer = CustomerFactory.buildCustomer("Jake", "Long",
                "jake.long@gmail.com", "jakeLong", "0677784626",
                LocalDate.of(2000, Month.JANUARY, 1));
        cart = CartFactory.buildCart(customer);
        String imageUrl = "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=";
        product = ProductFactory.buildProduct("Jalapeno", "Red hot jalapeno",
                50, imageUrl, 5, "Plant");
        int quantity = -1;
        double unitPrice = 10.0;

        CartProduct cartProduct = CartProductFactory.buildCartProduct(cart, product, quantity, unitPrice);

        assertNull(cartProduct, "CartProduct should be null when quantity is negative");
    }

    @Test
    public void testCreateCartProductWithNegativeUnitPrice() {
        customer = CustomerFactory.buildCustomer("Jake", "Long",
                "jake.long@gmail.com", "jakeLong", "0677784626",
                LocalDate.of(2000, Month.JANUARY, 1));
        cart = CartFactory.buildCart(customer);
        String imageUrl = "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=";
        product = ProductFactory.buildProduct("Jalapeno", "Red hot jalapeno",
                50, imageUrl, 5, "Plant");
        int quantity = 5;
        double unitPrice = -10.0;

        CartProduct cartProduct = CartProductFactory.buildCartProduct(cart, product, quantity, unitPrice);

        assertNull(cartProduct, "CartProduct should be null when unit price is negative");
    }

    @Test
    public void testCreateCartProductWithNullCart() {
        product = ProductFactory.buildProduct("Jalapeno", "Red hot jalapeno",
                50, "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=", 5, "Plant");
        int quantity = 5;
        double unitPrice = 10.0;

        CartProduct cartProduct = CartProductFactory.buildCartProduct(null, product, quantity, unitPrice);

        assertNull(cartProduct, "CartProduct should be null when cart is null");
    }

    @Test
    public void testCreateCartProductWithNullProduct() {
        customer = CustomerFactory.buildCustomer("Jake", "Long",
                "jake.long@gmail.com", "jakeLong", "0677784626",
                LocalDate.of(2000, Month.JANUARY, 1));
        cart = CartFactory.buildCart(customer);
        int quantity = 5;
        double unitPrice = 10.0;

        CartProduct cartProduct = CartProductFactory.buildCartProduct(cart, null, quantity, unitPrice);

        assertNull(cartProduct, "CartProduct should be null when product is null");
    }
}
