package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.GiftCard;

@Repository
public interface GiftCardRepository extends JpaRepository<GiftCard, Long> {
}
