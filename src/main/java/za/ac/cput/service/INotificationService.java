package za.ac.cput.service;

import za.ac.cput.domain.Notification;

import java.util.Set;

public interface INotificationService extends IService<Notification, Long> {

    Set<Notification> getAllNotifications();

    Notification saveNotification(Notification notification);

    Notification getNotificationById(Long notificationId);

    Notification updateNotification(Notification notification);

    void deleteNotification(Long notificationId);
}
