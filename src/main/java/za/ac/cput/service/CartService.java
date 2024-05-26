package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Cart;
import za.ac.cput.repository.CartRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CartService implements ICartService {
    private final CartRepository repository;

    @Autowired
    CartService(CartRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<Cart> getall() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Cart create(Cart cart) {
        return repository.save(cart);
    }

    @Override
    public Cart read(Long id) {
        return repository.findByCartId(id);
    }

    @Override
    public Cart update(Cart cart) {
        if (repository.existsById(cart.getCartId())) {
            return repository.save(cart);
        }
        return null;
    }

    @Override
    public void delete(Long cartId) {
        repository.deleteById(cartId);
    }
}
