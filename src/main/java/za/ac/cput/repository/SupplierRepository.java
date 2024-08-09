package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
