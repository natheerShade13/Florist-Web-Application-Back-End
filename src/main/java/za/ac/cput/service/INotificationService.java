package za.ac.cput.service;

import za.ac.cput.domain.Notification;

import java.util.Set;

public interface INotificationService extends IService<Notification, Long> {
    Set<Notification> getAllNotifications();
}
