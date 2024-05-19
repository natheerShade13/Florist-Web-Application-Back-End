package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Contact;

public interface IContactRepository extends JpaRepository<Contact,String>{
     Contact findID(String key);
}
