package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findByCustomer_CustomerId(Long customerId);

    Cart findByCustomer(Customer customer);
}
