package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Customer;
import za.ac.cput.service.CustomerService;

// Build objects using Factory to utilize Helper classes;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/login/{email}/{password}")
    public ResponseEntity<Customer> login(@PathVariable String email,
                                         @PathVariable String password){
        Customer verifyLogin = customerService.verifyLogin(email, password);
        return new ResponseEntity<>(verifyLogin, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer){
        Customer newCustomer = customerService.create(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/update") //
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.update(customer);
    }

}
