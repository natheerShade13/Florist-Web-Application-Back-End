package za.ac.cput.service;

import za.ac.cput.domain.Cart;

import java.util.Set;

public interface ICartService extends IService<Cart, Long>{
    Set<Cart> getall();

    Cart create(Cart cart);

    Cart read(Long id);

    Cart update(Cart cart);

    void delete(Long id);
}
