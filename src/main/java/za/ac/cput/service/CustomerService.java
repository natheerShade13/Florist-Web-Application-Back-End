package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.ICustomerRepository;

import java.util.List;
@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository repository;

    @Override
    public Customer create(Customer object) {
        return repository.save(object);
    }

    @Override
    public Customer read(Long aLong) {
        return repository.findById(aLong).orElse(null);
    }

    @Override
    public Customer update(Customer object) {
        return repository.save(object);
    }
    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }
}
