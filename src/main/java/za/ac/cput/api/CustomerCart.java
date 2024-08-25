package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.*;
import za.ac.cput.repository.CartProductRepository;
import za.ac.cput.repository.CartRepository;
import za.ac.cput.service.CartProductService;
import za.ac.cput.service.CustomerService;
import za.ac.cput.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerCart {

    private final CartProductRepository productRepository;
    private final CartRepository cartRepository;
    private final CustomerService customerService;
    private final CartProductRepository cartProductRepository;
    private final CartProductService cartProductService;
    private final ProductService productService;

    @Autowired
    public CustomerCart(CartProductRepository productRepository, CartRepository cartRepository, CustomerService customerService
            , CartProductRepository cartProductRepository, CartProductService cartProductService, ProductService productService) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.customerService = customerService;
        this.cartProductRepository = cartProductRepository;
        this.cartProductService = cartProductService;
        this.productService = productService;
    }

    public List<CartProduct> getCartProducts(long customerId) {
        //Customer customer = customerService.read(customerId);
        Cart cart = cartRepository.findByCustomer_CustomerId(customerId);
        return cartProductRepository.findByCart_CartId(cart.getCartId());
    }

    public CartProduct addProductToCart(long customerId, long productId) {
        Cart cart = cartRepository.findByCustomer_CustomerId(customerId);
        Product product = productService.read(productId);
        CartProduct cartProduct = cartProductRepository.findByCart_CartIdAndProduct_ProductId(cart.getCartId(), productId);

        if (cartProduct != null) {
            CartProduct updateCartProduct = new CartProduct.Builder().copy(cartProduct).setQuantity(cartProduct.getQuantity() + 1).build();
            return cartProductService.update(updateCartProduct);
        } else {
                   cartProduct = new CartProduct.Builder()
                    .setCartProductId(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE)
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
        //Product product = productService.read(productId);
        CartProduct cartProduct =cartProductRepository.findByCart_CartIdAndProduct_ProductId(cart.getCartId(), productId);

        if (cartProduct != null) {
            int quantity = cartProduct.getQuantity();

            if(quantity > 1){
                quantity--;
                CartProduct newCartProduct = new CartProduct.Builder().copy(cartProduct).setQuantity(quantity).build();
                cartProductService.update(newCartProduct);
                return true;
            }else {
                cartProductService.delete(cartProduct.getCartProductId());
                return false;
            }
        }
        return false;
    }

}
