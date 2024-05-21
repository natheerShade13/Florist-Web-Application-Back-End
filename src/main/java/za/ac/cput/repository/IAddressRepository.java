package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Address;
@Repository
public interface IAddressRepository extends JpaRepository<Address, Long> {

}
