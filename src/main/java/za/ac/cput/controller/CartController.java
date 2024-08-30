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
public class CartController {

    private final CustomerCart customerCart;

    @Autowired
    public CartController(CustomerCart customerCart) {
        this.customerCart = customerCart;
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<CartProduct>> getCustomerCart(@PathVariable long customerId) {
        List<CartProduct> customerCarts = customerCart.getCartProducts(customerId);
        return new ResponseEntity<>(customerCarts, HttpStatus.OK);
    }

    @PostMapping("/customerId/{customerId}/productId/{productId}")
    public ResponseEntity<CartProduct> addProductToCart(@PathVariable long customerId, @PathVariable long productId) {
        CartProduct cartProduct  = customerCart.addProductToCart(customerId, productId);
        return new ResponseEntity<>(cartProduct, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/customerId/{customerId}/productId/{productId}")
    public ResponseEntity<Boolean> deleteProductFromCart(@PathVariable long customerId, @PathVariable long productId){
        boolean cartProduct = customerCart.removeProductFromCart(customerId, productId);
        return new ResponseEntity<>(cartProduct, HttpStatus.OK);
    }
}