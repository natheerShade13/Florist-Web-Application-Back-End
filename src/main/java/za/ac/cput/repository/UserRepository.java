package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Customer;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);

}
