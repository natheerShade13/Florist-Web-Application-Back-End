package za.ac.cput.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Contact;
import za.ac.cput.repository.IContactRepository;

import java.util.List;
@Service
public class ContactService implements IContactService {
    @Autowired
    private IContactRepository repository;

    @Override
    public Contact create(Contact object) {
        return repository.save(object);
    }

    @Override
    public Contact read(String string) {
        return repository.findById(string).orElse(null);
    }

    @Override
    public Contact update(Contact object) {
        return repository.save(object);
    }
    @Override
    public List<Contact> getAll() {
        return repository.findAll();
    }
}
