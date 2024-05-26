package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.CartItem;
import za.ac.cput.repository.CartItemRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CartItemService implements ICartItemService {
    private CartItemRepository repository;

    @Autowired
    CartItemService(CartItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<CartItem> getAll() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public CartItem create(CartItem cartItem) {
        return repository.save(cartItem);
    }

    @Override
    public CartItem read(Long id) {
        return repository.findByCartItemId(id);
    }

    @Override
    public CartItem update(CartItem cartItem) {
        return repository.save(cartItem);
    }

    @Override
    public void delete(Long cartItemId) {
        repository.deleteById(cartItemId);
    }
}
