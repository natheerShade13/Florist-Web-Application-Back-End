package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Product;
import za.ac.cput.api.CustomerWishlist;
import za.ac.cput.domain.WishlistProduct;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class CustomerWishlistController {

    private final CustomerWishlist customerWishlist;

    @Autowired
    public CustomerWishlistController(CustomerWishlist customerWishlist) {
        this.customerWishlist = customerWishlist;
    }

    // Add a product to a customer's wishlist
    @PostMapping("/{customerId}/addProduct")
    public ResponseEntity<WishlistProduct> addProductToWishlist(@PathVariable long customerId, @RequestBody Product product) {
        WishlistProduct wishlistProduct = customerWishlist.addProductToWishlist(customerId, product);
        return new ResponseEntity<>(wishlistProduct, HttpStatus.CREATED);
    }

    // Remove a product from a customer's wishlist
    @DeleteMapping("/{wishlistId}/removeProduct/{productId}")
    public ResponseEntity<Boolean> removeProductFromWishlist(@PathVariable long wishlistId, @PathVariable long productId) {
        boolean removeWishlistProduct = customerWishlist.removeProductFromWishlist(wishlistId, productId);
        return new ResponseEntity<>(removeWishlistProduct, HttpStatus.OK);
    }

    // Get all products in a customer's wishlist
    @GetMapping("/customer/{customerId}/products")
    public ResponseEntity<List<Product>> getProductsInCustomerWishlist(@PathVariable long customerId) {
        List<Product> products = customerWishlist.getProductsInCustomerWishlist(customerId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
