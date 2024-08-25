package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.CartProduct;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartProductRepository extends JpaRepository <CartProduct, Long> {
    List<CartProduct> findByCart_CartId(Long cartId);
    CartProduct findByCart_CartIdAndProduct_ProductId(Long cartId, Long productId);
    //void deleteByCart_CartIdAndProduct_ProductId(Long cartId, Long productId);
    //Optional<CartProduct> findByCustomer_CustomerIdAndProduct_ProductId(Long customerId, Long productId);
}