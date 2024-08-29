package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Wishlist;
import za.ac.cput.domain.WishlistProduct;
import java.util.Optional;
import java.util.List;

@Repository
public interface WishlistProductRepository extends JpaRepository<WishlistProduct, Long> {

    // Find all WishlistProduct entries by a given Wishlist
    List<WishlistProduct> findByWishlist(Wishlist wishlist);

    // Find a WishlistProduct by both Wishlist and Product
    Optional<WishlistProduct> findByWishlistAndProduct(Wishlist wishlist, Product product);
}
