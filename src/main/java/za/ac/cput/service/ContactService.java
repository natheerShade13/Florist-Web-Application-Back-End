package za.ac.cput.service;


import za.ac.cput.domain.Contact;
import za.ac.cput.repository.IContactRepository;

import java.util.List;

public class ContactService implements IContactService {
    private IContactRepository repository;

    @Override
    public Contact create(Contact object) {
        return repository.save(object);
    }

    @Override
    public Contact read(String string) {
        return repository.findID(string);
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
