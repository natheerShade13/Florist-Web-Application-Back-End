package za.ac.cput.service;

import za.ac.cput.domain.Contact;

import java.util.List;

public interface IContactService extends IService<Contact, String>{

    List<Contact> getAll();
}
