package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
