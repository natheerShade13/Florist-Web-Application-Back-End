package za.ac.cput.service;

import za.ac.cput.domain.Customer;

import java.util.List;

public interface ICustomerService extends IService<Customer,Long> {
    List<Customer> getAll();
}
