package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
