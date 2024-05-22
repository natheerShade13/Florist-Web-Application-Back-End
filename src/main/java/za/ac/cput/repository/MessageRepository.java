package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
