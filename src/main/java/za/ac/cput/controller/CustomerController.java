package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Customer;
import za.ac.cput.service.CustomerService;

import java.util.List;

// Build objects using Factory to utilize Helper classes;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/login/{email}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String email){
        Customer customer = customerService.getCustomer(email);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/login/{email}/{password}")
    public ResponseEntity<Boolean> login(@PathVariable String email,
                                          @PathVariable String password){
        boolean verifyLogin = customerService.verifyLogin(email, password);
        return new ResponseEntity<>(verifyLogin, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAll(){
        List<Customer> customerList = customerService.getAll();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        Customer updateCustomer = customerService.update(customer);
        return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
    }

//    @PutMapping("/update") //
//    public Customer updateCustomer(@RequestBody Customer customer){
//        return customerService.update(customer);
//    }

    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable long customerId){
        boolean deleteCustomer = customerService.delete(customerId);
        return new ResponseEntity<>(deleteCustomer, HttpStatus.OK);
    }

}
