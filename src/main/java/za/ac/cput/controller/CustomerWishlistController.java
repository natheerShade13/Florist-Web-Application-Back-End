package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Product;
import za.ac.cput.api.CustomerWishlist;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class CustomerWishlistController {

    private final CustomerWishlist customerWishlist;

    @Autowired
    public CustomerWishlistController(CustomerWishlist customerWishlist) {
        this.customerWishlist = customerWishlist;
    }

    // Add a product to a customer's wishlist
    @PostMapping("/{wishlistId}/addProduct/{productId}")
    public ResponseEntity<String> addProductToWishlist(@PathVariable long wishlistId, @PathVariable long productId) {
        customerWishlist.addProductToWishlist(wishlistId, productId);
        return new ResponseEntity<>("Product added to wishlist successfully", HttpStatus.OK);
    }

    // Remove a product from a customer's wishlist
    @DeleteMapping("/{wishlistId}/removeProduct/{productId}")
    public ResponseEntity<String> removeProductFromWishlist(@PathVariable long wishlistId, @PathVariable long productId) {
        customerWishlist.removeProductFromWishlist(wishlistId, productId);
        return new ResponseEntity<>("Product removed from wishlist successfully", HttpStatus.OK);
    }

    // Get all products in a customer's wishlist
    @GetMapping("/customer/{customerId}/products")
    public ResponseEntity<List<Product>> getProductsInCustomerWishlist(@PathVariable long customerId) {
        List<Product> products = customerWishlist.getProductsInCustomerWishlist(customerId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
