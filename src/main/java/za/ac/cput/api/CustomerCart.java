package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartProduct;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;
import za.ac.cput.repository.CartProductRepository;
import za.ac.cput.repository.CartRepository;
import za.ac.cput.service.CartProductService;
import za.ac.cput.service.ProductService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerCart {

    private final CartRepository cartRepository;
    private final CartProductRepository cartProductRepository;
    private final CartProductService cartProductService;
    private final ProductService productService;

    @Autowired
    public CustomerCart(CartRepository cartRepository, CartProductRepository cartProductRepository,
                        CartProductService cartProductService, ProductService productService) {
        this.cartRepository = cartRepository;
        this.cartProductRepository = cartProductRepository;
        this.cartProductService = cartProductService;
        this.productService = productService;
    }

    public List<CartProduct> getCartProducts(long customerId) {
        Optional<Cart> optionalCart = Optional.ofNullable(cartRepository.findByCustomer_CustomerId(customerId));
        if (optionalCart.isEmpty()) {
            return List.of(); // Return an empty list if cart is null
        }
        return cartProductRepository.findByCart_CartId(optionalCart.get().getCartId());
    }

    public CartProduct addProductToCart(long customerId, long productId) {
        Cart cart = cartRepository.findByCustomer_CustomerId(customerId);
        if (cart == null) {
            // Create a new cart for the customer if it doesn't exist
            Customer customer = new Customer.Builder()
                    .setCustomerId(customerId)
                    .build();
            cart = new Cart.Builder()
                    .setCustomer(customer)
                    .setDateCreated(LocalDate.now())
                    .build();
            cart = cartRepository.save(cart);
        }

        Product product = productService.read(productId);
        CartProduct cartProduct = cartProductRepository.findByCart_CartIdAndProduct_ProductId(cart.getCartId(), productId);

        if (cartProduct != null) {
            CartProduct updateCartProduct = new CartProduct.Builder()
                    .copy(cartProduct)
                    .setQuantity(cartProduct.getQuantity() + 1)
                    .build();
            return cartProductService.update(updateCartProduct);
        } else {
            cartProduct = new CartProduct.Builder()
                    .setCart(cart)
                    .setProduct(product)
                    .setQuantity(1)
                    .setUnitPrice(product.getPrice())
                    .build();
        }
        return cartProductService.create(cartProduct);
    }

    public boolean removeProductFromCart(long customerId, long productId) {
        Cart cart = cartRepository.findByCustomer_CustomerId(customerId);
        if (cart == null) {
            return false;
        }
        CartProduct cartProduct = cartProductRepository.findByCart_CartIdAndProduct_ProductId(cart.getCartId(), productId);

        if (cartProduct != null) {
            int quantity = cartProduct.getQuantity();

            if (quantity > 1) {
                quantity--;
                CartProduct newCartProduct = new CartProduct.Builder()
                        .copy(cartProduct)
                        .setQuantity(quantity)
                        .build();
                cartProductService.update(newCartProduct);
                return true;
            } else {
                cartProductService.delete(cartProduct.getCartProductId());
                return true; // Adjusted to return true when a product is removed
            }
        }
        return false;
    }
}