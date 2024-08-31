package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.api.OrdersCheckout;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Orders;
import za.ac.cput.repository.OrdersRepository;
import za.ac.cput.service.CustomerService;
import za.ac.cput.service.OrdersService;

import java.util.List;

@RestController
@RequestMapping("/checkout")
public class OrdersCheckoutController {

    private final OrdersCheckout ordersCheckout;
    private final CustomerService customerService;

    @Autowired
    public OrdersCheckoutController(OrdersCheckout ordersCheckout, CustomerService customerService) {
        this.ordersCheckout = ordersCheckout;
        this.customerService = customerService;
    }

    @PostMapping("/add")
    public ResponseEntity<Orders> checkout(@RequestBody Customer customer) {
        Orders order = ordersCheckout.checkout(customer);
        try {
            return new ResponseEntity<>(order, HttpStatus.CREATED);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/history/{customerId}")
    public ResponseEntity<List<Orders>> getOrderHistory(@PathVariable long customerId) {
        Customer customer = customerService.read(customerId);
        List<Orders> orders = ordersCheckout.getAllOrdersByCustomer(customer);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

//    @GetMapping("/customer/{customerId}")
//    public ResponseEntity<List<Orders>> getAllOrdersByCustomer(@PathVariable Long customerId) {
//        Customer customer = customerService.read(customerId);
//        if (customer == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        List<Orders> orders = ordersCheckout.getAllOrdersWithOrderLinesByCustomer(customer);
//        return ResponseEntity.ok(orders);
//    }
}
