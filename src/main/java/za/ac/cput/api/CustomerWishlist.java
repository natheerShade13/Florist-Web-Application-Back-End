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
import za.ac.cput.service.CustomerService;
import za.ac.cput.service.ProductService;
import za.ac.cput.service.WishlistProductService;
import za.ac.cput.service.WishlistService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerWishlist {

    private final WishlistRepository wishlistRepository;
    private final WishlistProductRepository wishlistProductRepository;
    private final WishlistProductService wishlistProductService;
    private final WishlistService wishlistService;
    private final ProductService productService;
    private final CustomerService customerService;

    @Autowired
    public CustomerWishlist(WishlistRepository wishlistRepository,WishlistProductRepository wishlistProductRepository,
                            WishlistProductService wishlistProductService, WishlistService wishlistService,
                            ProductService productService, CustomerService customerService) {
        this.wishlistRepository = wishlistRepository;
        this.wishlistProductRepository = wishlistProductRepository;
        this.wishlistProductService = wishlistProductService;
        this.wishlistService = wishlistService;
        this.productService = productService;
        this.customerService = customerService;
    }

    public WishlistProduct addProductToWishlist(long customerId, Product product) {
        Customer customer = customerService.read(customerId);
        Wishlist wishlist = wishlistRepository.findByCustomer(customer)
                .orElseThrow(() -> new RuntimeException("Wishlist not found"));
        Product productFind = productService.read(product.getProductId());

        WishlistProduct wishlistProduct = new WishlistProduct.Builder()
                .setWishlistProductId(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE)
                .setWishlist(wishlist)
                .setProduct(productFind)
                .build();

        return wishlistProductService.create(wishlistProduct);
    }

    public boolean removeProductFromWishlist(long customerId, long productId) {
        Customer customer = customerService.read(customerId);
        Wishlist wishlist = wishlistRepository.findByCustomer(customer)
                .orElseThrow(() -> new RuntimeException("Wishlist not found"));
        Product product = productService.read(productId);

        WishlistProduct wishlistProduct = wishlistProductRepository.findByWishlistAndProduct(wishlist, product)
                .orElseThrow(() -> new RuntimeException("Product not found in wishlist"));

        return wishlistProductService.delete(wishlistProduct.getWishlistProductId());
    }

    public List<Product> getProductsInCustomerWishlist(long customerId) {
        Customer customer = customerService.read(customerId);
        Wishlist wishlist = wishlistRepository.findByCustomer(customer)
                .orElseThrow(() -> new RuntimeException("Wishlist not found"));

        List<WishlistProduct> wishlistProducts = wishlistProductRepository.findByWishlist(wishlist);
        return wishlistProducts.stream()
                .map(WishlistProduct::getProduct)
                .collect(Collectors.toList());
    }
}
