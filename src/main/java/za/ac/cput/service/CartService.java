package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Cart;
import za.ac.cput.repository.CartRepository;

import java.util.List;

@Service
public class CartService implements IService<Cart, Long>{

    @Autowired
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart create(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart read(Long aLong) {
        return cartRepository.findById(aLong).orElseThrow(() -> new IllegalStateException("Cart with ID " + aLong
                + " does not exist"));
    }

    @Override
    public Cart update(Cart cart) {
        if (cartRepository.existsById(cart.getCartId())){
            return cartRepository.save(cart);
        } else {
            throw new IllegalStateException("Cart with ID " + cart.getCartId() + " does not exist");
        }
    }

    @Override
    public boolean delete(Long d) {
        if (cartRepository.existsById(d)){
            cartRepository.deleteById(d);
            return true;
        } else {
            throw new IllegalStateException("Cart with ID " + d + " does not exist");
        }
    }

    @Override
    public List<Cart> getAll() {
        return cartRepository.findAll();
    }
}
