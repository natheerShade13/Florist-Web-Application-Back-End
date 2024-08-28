package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.api.CustomerCart;
import za.ac.cput.domain.CartProduct;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CustomerCartController {

    private final CustomerCart customerCart;

    @Autowired
    public CustomerCartController(CustomerCart customerCart) {
        this.customerCart = customerCart;
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<CartProduct>> getCustomerCart(@PathVariable long customerId) {
        List<CartProduct> customerCarts = customerCart.getCartProducts(customerId);
        return new ResponseEntity<>(customerCarts, HttpStatus.OK);
    }

    @PostMapping("/customerId/{customerId}/productId/{productId}")
    public ResponseEntity<?> addProductToCart(@PathVariable long customerId, @PathVariable long productId) {
        try {
            CartProduct cartProduct = customerCart.addProductToCart(customerId, productId);
            return new ResponseEntity<>(cartProduct, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/customerId/{customerId}/productId/{productId}")
    public ResponseEntity<?> deleteProductFromCart(@PathVariable long customerId, @PathVariable long productId) {
        try {
            boolean cartProduct = customerCart.removeProductFromCart(customerId, productId);
            return new ResponseEntity<>(cartProduct, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    // ErrorResponse class
    public class ErrorResponse {
        private String message;

        public ErrorResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}