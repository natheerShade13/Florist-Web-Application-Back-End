package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Customer;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    Customer findID(Long key);
}
