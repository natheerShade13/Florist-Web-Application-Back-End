package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Notification;
import za.ac.cput.repository.NotificationRepository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class NotificationService implements INotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Set<Notification> getAllNotifications() {
        return notificationRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Notification create(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification read(Long id) {
        Optional<Notification> notification = notificationRepository.findById(id);
        return notification.orElse(null);
    }

    @Override
    public Notification update(Notification notification) {
        if (notificationRepository.existsById(notification.getNotificationId())) {
            return notificationRepository.save(notification);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        if (notificationRepository.existsById(id)) {
            notificationRepository.deleteById(id);
        }
    }
}
