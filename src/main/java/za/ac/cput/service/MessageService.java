package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Message;
import za.ac.cput.repository.MessageRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MessageService implements IMessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Set<Message> getAllMessages() {
        return messageRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Message getMessageById(Long messageId) {
        return messageRepository.findById(messageId).orElse(null);
    }

    @Override
    public Message updateMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public void deleteMessage(Long messageId) {
        messageRepository.deleteById(messageId);
    }

    @Override
    public Message create(Message message) {
        return null;
    }

    @Override
    public Message read(Long aLong) {
        return null;
    }

    @Override
    public Message update(Message message) {
        return null;
    }
}
