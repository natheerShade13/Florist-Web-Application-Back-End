package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
