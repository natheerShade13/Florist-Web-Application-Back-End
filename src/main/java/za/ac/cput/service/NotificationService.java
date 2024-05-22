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
    public Notification saveNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification getNotificationById(Long notificationId) {
        Optional<Notification> optionalNotification = notificationRepository.findById(notificationId);
        return optionalNotification.orElse(null);
    }

    @Override
    public Notification updateNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public void deleteNotification(Long notificationId) {
        notificationRepository.deleteById(notificationId);
    }

    @Override
    public Notification create(Notification notification) {
        return null;
    }

    @Override
    public Notification read(Long aLong) {
        return null;
    }

    @Override
    public Notification update(Notification notification) {
        return null;
    }
}
