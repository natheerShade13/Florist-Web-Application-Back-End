package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Role;
import za.ac.cput.dto.CustomerDto;
import za.ac.cput.dto.UserDto;
import za.ac.cput.mapper.UserMapper;
import za.ac.cput.security.service.AuthenticationService;
import za.ac.cput.service.CustomerService;

import java.util.List;

// Build objects using Factory to utilize Helper classes;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final AuthenticationService authenticationService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomerController(CustomerService customerService, AuthenticationService authenticationService, PasswordEncoder passwordEncoder) {
        this.customerService = customerService;
        this.authenticationService = authenticationService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login/{email}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable String email) {
        Customer customer = customerService.getCustomer(email);
        if (customer == null) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        } else {
            CustomerDto customerDto = UserMapper.mapOut(customer);
            return new ResponseEntity<>(customerDto, HttpStatus.OK);
        }
    }

    @GetMapping("/update/{mobileNumber}")
    public ResponseEntity<Customer> getCustomerByMobileNumber(@PathVariable String mobileNumber) {
        Customer customer = customerService.getCustomerByMobileNumber(mobileNumber);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/login/{email}/{password}")
    public ResponseEntity<UserDto> authenticate(@PathVariable String email,
                                                @PathVariable String password) {
        return new ResponseEntity<>(authenticationService.authenticate(email, password), HttpStatus.OK);
    }

    @GetMapping("/login/admin/{email}/{password}")
    public ResponseEntity<UserDto> authenticateAdmin(@PathVariable String email,
                                                @PathVariable String password) {
        return new ResponseEntity<>(authenticationService.authenticateAdmin(email, password), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAll() {
        List<Customer> customerList = customerService.getAll();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        customer.setRole(Role.USER);
        Customer updateCustomer = customerService.update(customer);
        return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
    }

    @PutMapping("/update/password")
    public ResponseEntity<Customer> updatePassword(@RequestBody Customer customer) {
        customer.setRole(Role.USER);
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        Customer updateCustomer = customerService.update(customer);
        return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable long customerId) {
        boolean deleteCustomer = customerService.delete(customerId);
        return new ResponseEntity<>(deleteCustomer, HttpStatus.OK);
    }

}
