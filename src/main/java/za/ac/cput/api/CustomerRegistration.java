package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Role;
import za.ac.cput.domain.Wishlist;
import za.ac.cput.dto.CustomerDto;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.factory.WishlistFactory;
import za.ac.cput.service.CartService;
import za.ac.cput.service.CustomerService;
import za.ac.cput.service.WishlistService;

@Service
public class CustomerRegistration {

    private final CustomerService customerService;
    private final CartService cartService;
    private final WishlistService wishlistService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomerRegistration(CustomerService customerService, CartService cartService, WishlistService wishlistService, PasswordEncoder passwordEncoder) {
        this.customerService = customerService;
        this.cartService = cartService;
        this.wishlistService = wishlistService;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public Customer registerCustomer(CustomerDto customerDto) {

        Customer customer = new Customer.Builder()
                .setFirstName(customerDto.getFirstName())
                .setLastName(customerDto.getLastName())
                .setEmail(customerDto.getEmail())
                .setPassword(passwordEncoder.encode(customerDto.getPassword()))
                .setRole(Role.USER)
                .build();

        // Create the customer
        Customer createdCustomer = customerService.create(customer);
        if (createdCustomer == null) {
            throw new IllegalStateException("Customer registration failed.");
        }

        // Create the cart for the customer
        Cart cart = CartFactory.buildCart(createdCustomer);
        Cart createdCart = cartService.create(cart);
        if (createdCart == null) {
            throw new IllegalStateException("Failed to create cart for the customer.");
        }

        // Create the wishlist for the customer
        Wishlist wishlist = WishlistFactory.buildWishlist(createdCustomer);
        Wishlist createdWishlist = wishlistService.create(wishlist);
        if (createdWishlist == null) {
            throw new IllegalStateException("Failed to create wishlist for the customer.");
        }

        // If everything succeeds, return the registered customer
        return createdCustomer;
    }

}
