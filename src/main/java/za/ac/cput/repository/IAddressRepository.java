package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Address;

public interface IAddressRepository extends JpaRepository<Address, Long> {
    Address findID(Long key);
}
