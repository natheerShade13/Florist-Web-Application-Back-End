package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Message;
import za.ac.cput.repository.MessageRepository;

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
    public Message create(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Message read(Long id) {
        Optional<Message> message = messageRepository.findById(id);
        return message.orElse(null); // Or throw a custom exception if not found
    }

    @Override
    public Message update(Message message) {
        if (messageRepository.existsById(message.getMessageId())) {
            return messageRepository.save(message);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        if (messageRepository.existsById(id)) {
            messageRepository.deleteById(id);
        }
    }
}
