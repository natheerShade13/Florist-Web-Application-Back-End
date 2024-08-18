package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Wishlist;

import java.util.Optional;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    Optional<Wishlist> findByCustomer(Customer customer);
}
