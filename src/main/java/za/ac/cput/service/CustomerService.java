package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

//Create API for calculating the (orders amount - coupon discount); Done
//When using create, check for certain conditions;
//Delete method might need changing;

@Service
public class CustomerService implements IService<Customer, Long>{

    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer create(Customer customer) {

        /* This throws an exception if the same id is used

        if (customerRepository.existsById(customer.getCustomerId())){
            throw new IllegalStateException("Customer with Id " + customer.getCustomerId() + " already exists");
        }
         */

        /* Not using the following for now, cause it makes the testing a bit difficult due to the amount of
        foreign keys customer belongs to. This works though.

        Optional<Customer> findCustomer = customerRepository.findByEmail(customer.getEmail());
        if(findCustomer.isPresent()){
            throw new IllegalStateException("Email already taken.");
        }
        */

        /* This way uses both of the above the correct way

        if (customerRepository.existsById(customer.getCustomerId())){
            return customerRepository.save(customer);
        } else{
            Optional<Customer> findCustomer = customerRepository.findByEmail(customer.getEmail());
            if(findCustomer.isPresent()){
                throw new IllegalStateException("Email already taken.");
        }
         */
        return customerRepository.save(customer);
    }

    @Override
    public Customer read(Long aLong) {
        return customerRepository.findById(aLong).orElseThrow(()-> new IllegalStateException("Customer with " +
                "Id " + aLong + " does not exist"));
    }

    @Override
    public Customer update(Customer customer) {
        if (customerRepository.existsById(customer.getCustomerId())){
            return customerRepository.save(customer);
        } else {
            throw new IllegalStateException("Customer with Id " + customer.getCustomerId() + " does not exist");
        }
    }

    @Override
    public boolean delete(Long d) {
        if (customerRepository.existsById(d)){
            customerRepository.deleteById(d);
            return true;
        } else {
            throw new IllegalStateException("Customer with Id " + d + " does not exist");
        }
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public boolean verifyLogin(String email, String password){
        Optional<Customer> verifyCustomer = customerRepository.findByEmailAndPassword(email, password);

        return verifyCustomer.isPresent();
    }
}
