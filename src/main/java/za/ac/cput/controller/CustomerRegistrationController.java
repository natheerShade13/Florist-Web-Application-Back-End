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
import za.ac.cput.dto.UserDto;

@RestController
@RequestMapping(path = "/customer")
public class CustomerRegistrationController {

    private final CustomerRegistration customerRegistration;

    @Autowired
    public CustomerRegistrationController(CustomerRegistration customerRegistration) {
        this.customerRegistration = customerRegistration;
    }

    @PostMapping(path = "/register")
    public ResponseEntity<Customer> customerRegistration(@RequestBody UserDto userDto) {
        try {
            Customer newCustomer = customerRegistration.registerCustomer(userDto);
            return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
        } catch (IllegalStateException e) {
            // Return a specific error message from the exception
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            // For any other unexpected exceptions, return a generic error message
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
