package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {

}
