package za.ac.cput.service;

import za.ac.cput.domain.Message;

import java.util.Set;

public interface IMessageService extends IService<Message, Long> {

    Set<Message> getAllMessages();
}
