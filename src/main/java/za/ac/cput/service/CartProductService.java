package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.CartProduct;
import za.ac.cput.repository.CartProductRepository;

import java.util.List;

@Service
public class CartProductService implements IService<CartProduct, Long> {

    private final CartProductRepository cartProductRepository;

    @Autowired
    public CartProductService(CartProductRepository cartProductRepository) {
        this.cartProductRepository = cartProductRepository;
    }

    @Override
    public CartProduct read(Long id) {
        return cartProductRepository.findById(id).orElse(null);
    }

    @Override
    public CartProduct create(CartProduct cartProduct) {
        if (cartProduct == null) {
            throw new IllegalArgumentException("CartProduct must not be null");
        }

        if (cartProduct.getQuantity() < 0 || cartProduct.getUnitPrice() < 0) {
            throw new IllegalArgumentException("Quantity and unitPrice must be non-negative");
        }

        // Calculate the total price
        double totalPrice = cartProduct.getQuantity() * cartProduct.getUnitPrice();
        cartProduct.setTotalPrice(totalPrice);

        // Save the CartProduct entity
        try {
            return cartProductRepository.save(cartProduct);
        } catch (Exception e) {
            // Log the exception or handle it as necessary
            throw new RuntimeException("Failed to create CartProduct", e);
        }
    }

    @Override
    public CartProduct update(CartProduct cartProduct) {
        if (cartProductRepository.existsById(cartProduct.getCartProductId())) {
            return cartProductRepository.save(cartProduct);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        if (cartProductRepository.existsById(id)) {
            cartProductRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<CartProduct> getAll() {
        return cartProductRepository.findAll();
    }

    public List<CartProduct> getCartProductsByCart(long cartId) {
        return cartProductRepository.findByCart_CartId(cartId);
    }
}