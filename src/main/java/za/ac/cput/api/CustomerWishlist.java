package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Wishlist;
import za.ac.cput.domain.WishlistProduct;
import za.ac.cput.repository.CustomerRepository;
import za.ac.cput.repository.ProductRepository;
import za.ac.cput.repository.WishlistProductRepository;
import za.ac.cput.repository.WishlistRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerWishlist {

    private final WishlistRepository wishlistRepository;
    private final ProductRepository productRepository;
    private final WishlistProductRepository wishlistProductRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerWishlist(WishlistRepository wishlistRepository, ProductRepository productRepository,
                                  WishlistProductRepository wishlistProductRepository, CustomerRepository customerRepository) {
        this.wishlistRepository = wishlistRepository;
        this.productRepository = productRepository;
        this.wishlistProductRepository = wishlistProductRepository;
        this.customerRepository = customerRepository;
    }

    public void addProductToWishlist(long wishlistId, long productId) {
        Wishlist wishlist = wishlistRepository.findById(wishlistId)
                .orElseThrow(() -> new RuntimeException("Wishlist not found"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        WishlistProduct wishlistProduct = new WishlistProduct.Builder()
                .setWishlist(wishlist)
                .setProduct(product)
                .build();

        wishlistProductRepository.save(wishlistProduct);
    }

    public void removeProductFromWishlist(long wishlistId, long productId) {
        Wishlist wishlist = wishlistRepository.findById(wishlistId)
                .orElseThrow(() -> new RuntimeException("Wishlist not found"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        WishlistProduct wishlistProduct = wishlistProductRepository.findByWishlistAndProduct(wishlist, product)
                .orElseThrow(() -> new RuntimeException("Product not found in wishlist"));

        wishlistProductRepository.delete(wishlistProduct);
    }

    public List<Product> getProductsInCustomerWishlist(long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Wishlist wishlist = wishlistRepository.findByCustomer(customer)
                .orElseThrow(() -> new RuntimeException("Wishlist not found"));

        List<WishlistProduct> wishlistProducts = wishlistProductRepository.findByWishlist(wishlist);
        return wishlistProducts.stream()
                .map(WishlistProduct::getProduct)
                .collect(Collectors.toList());
    }
}
