package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.WishlistProduct;

@Repository
public interface WishlistProductRepository extends JpaRepository<WishlistProduct, Long> {
}
