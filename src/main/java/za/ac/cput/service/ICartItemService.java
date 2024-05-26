package za.ac.cput.service;

import za.ac.cput.domain.CartItem;

import java.util.Set;

public interface ICartItemService extends IService<CartItem, Long>{
    Set<CartItem> getAll();

    CartItem create(CartItem cartItem);

    CartItem read(Long id);

    CartItem update(CartItem cartItem);

    void delete(Long id);
}
