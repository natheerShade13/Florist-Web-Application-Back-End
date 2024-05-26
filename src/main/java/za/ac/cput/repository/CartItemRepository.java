package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.CartItem;

import java.util.Optional;

public interface CartItemRepository extends JpaRepository <CartItem,Long> {
    CartItem findByCartItemId(Long id);

}

