package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Role;
import za.ac.cput.domain.Wishlist;
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

    @Autowired
    public CustomerRegistration(CustomerService customerService, CartService cartService, WishlistService wishlistService) {
        this.customerService = customerService;
        this.cartService = cartService;
        this.wishlistService = wishlistService;
    }

    @Transactional
    public Customer registerCustomer(Customer customer) {
        Customer customerNew = customerService.create(customer);
        Cart cart = CartFactory.buildCart(customerNew);
        Cart cartTest = cartService.create(cart);
        Wishlist wishlist = WishlistFactory.buildWishlist(customerNew);
        Wishlist wishlistTest = wishlistService.create(wishlist);

        //if (customerNew == customer && cartTest == cart && wishlistTest == wishlist) {
            return customerNew;
        //} else {
        //    throw new IllegalStateException("error");
        //}
    }

}
