package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Customer;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    //List<Address> findAllByCustomer_CustomerId(long id);

}
