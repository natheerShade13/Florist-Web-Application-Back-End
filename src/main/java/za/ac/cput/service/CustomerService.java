package za.ac.cput.service;

import za.ac.cput.domain.Customer;
import za.ac.cput.repository.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService{
    private ICustomerRepository repository;

    @Override
    public Customer create(Customer object) {
        return repository.save(object);
    }

    @Override
    public Customer read(Long aLong) {
        return repository.findID(aLong);
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
