package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Wishlist;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.factory.WishlistFactory;
import za.ac.cput.repository.CartRepository;
import za.ac.cput.repository.CustomerRepository;
import za.ac.cput.repository.WishlistRepository;

@Service
public class CustomerRegistration {

    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;
    private final WishlistRepository wishlistRepository;

    @Autowired
    public CustomerRegistration(CustomerRepository customerRepository, CartRepository cartRepository, WishlistRepository wishlistRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.wishlistRepository = wishlistRepository;
    }

    public Customer registerCustomer(Customer customer) {
        Customer customerNew = customerRepository.save(customer);
        Cart cart = CartFactory.buildCart(customerNew);
        Cart cartTest = cartRepository.save(cart);
        Wishlist wishlist = WishlistFactory.buildWishlist(customerNew);
        Wishlist wishlistTest = wishlistRepository.save(wishlist);

        //if (customerNew == customer && cartTest == cart && wishlistTest == wishlist) {
            return customerNew;
        //} else {
        //    throw new IllegalStateException("error");
        //}
    }

}
