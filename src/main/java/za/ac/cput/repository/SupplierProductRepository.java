package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.SupplierProduct;

@Repository
public interface SupplierProductRepository extends JpaRepository<SupplierProduct, String> {
}
