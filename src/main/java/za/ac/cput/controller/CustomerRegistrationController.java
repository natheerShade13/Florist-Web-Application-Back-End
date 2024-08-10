package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.api.CustomerRegistration;
import za.ac.cput.domain.Customer;

@RestController
@RequestMapping(path = "/customer")
public class CustomerRegistrationController {

    private final CustomerRegistration customerRegistration;

    @Autowired
    public CustomerRegistrationController(CustomerRegistration customerRegistration) {
        this.customerRegistration = customerRegistration;
    }

    @PostMapping(path = "/registerB")
    public ResponseEntity<Customer> customerRegistration(@RequestBody Customer customer) {
        Customer newCustomer = customerRegistration.registerCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

}
