package za.ac.cput.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.CartProduct;
import za.ac.cput.repository.CartProductRepository;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class CartProductService implements IService<CartProduct, Long> {

    private static final Logger logger = LoggerFactory.getLogger(CartProductService.class);
    private final CartProductRepository cartProductRepository;

    @Autowired
    public CartProductService(CartProductRepository cartProductRepository) {
        this.cartProductRepository = cartProductRepository;
    }

    @Override
    public CartProduct create(CartProduct cartProduct) {
        if (cartProduct == null) {
            throw new IllegalArgumentException("CartProduct cannot be null");
        }
        logger.info("Creating CartProduct with ID: {}", cartProduct.getCartProductId());
        return cartProductRepository.save(cartProduct);
    }

    @Override
    public CartProduct read(Long id) {
        logger.info("Reading CartProduct with ID: {}", id);
        return cartProductRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("CartProduct with ID " + id + " does not exist"));
    }

    public CartProduct update(CartProduct cartProduct) {
        if (cartProductRepository.existsById(cartProduct.getCartProductId())) {
            return cartProductRepository.save(cartProduct);
        }
        throw new IllegalStateException("CartProduct with ID " + cartProduct.getCartProductId() + " does not exist");
    }

    @Override
    public boolean delete(Long id) {
        if (cartProductRepository.existsById(id)) {
            cartProductRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<CartProduct> getAll() {
        return cartProductRepository.findAll();
    }

    public List<CartProduct> getCartProductsByCart(Long cartId) {
        logger.info("Retrieving CartProducts for Cart ID: {}", cartId);
        return cartProductRepository.findByCart_CartId(cartId);
    }
}