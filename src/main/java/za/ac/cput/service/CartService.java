package za.ac.cput.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Cart;
import za.ac.cput.repository.CartRepository;

import java.util.List;

@Service
public class CartService implements IService<Cart, Long> {

    private static final Logger logger = LoggerFactory.getLogger(CartService.class);
    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart create(Cart cart) {
        if (cart == null) {
            throw new IllegalArgumentException("Cart cannot be null");
        }
        logger.info("Creating Cart with ID: {}", cart.getCartId());
        return cartRepository.save(cart);
    }

    @Override
    public Cart read(Long id) {
        logger.info("Reading Cart with ID: {}", id);
        return cartRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cart with ID " + id + " does not exist"));
    }

    @Override
    public Cart update(Cart cart) {
        if (cart == null) {
            throw new IllegalArgumentException("Cart cannot be null");
        }
        Long cartId = cart.getCartId();
        if (cartRepository.existsById(cartId)) {
            logger.info("Updating Cart with ID: {}", cartId);
            return cartRepository.save(cart);
        } else {
            throw new IllegalStateException("Cart with ID " + cartId + " does not exist");
        }
    }

    @Override
    public boolean delete(Long id) {
        if (cartRepository.existsById(id)) {
            logger.info("Deleting Cart with ID: {}", id);
            cartRepository.deleteById(id);
            return true;
        } else {
            throw new IllegalStateException("Cart with ID " + id + " does not exist");
        }
    }

    @Override
    public List<Cart> getAll() {
        logger.info("Retrieving all Carts");
        return cartRepository.findAll();
    }

    public Cart findByCustomerId(Long customerId) {
        logger.info("Finding Cart for customer with ID: {}", customerId);
        return cartRepository.findByCustomer_CustomerId(customerId);
    }
}