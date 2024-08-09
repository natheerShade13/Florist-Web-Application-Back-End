package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.WishlistProduct;
import za.ac.cput.repository.WishlistProductRepository;

import java.util.List;

@Service
public class WishlistProductService implements IService<WishlistProduct, Long> {

    @Autowired
    private WishlistProductRepository wishlistProductRepository;

    public WishlistProductService(WishlistProductRepository wishlistProductRepository) {
        this.wishlistProductRepository = wishlistProductRepository;
    }

    @Override
    public WishlistProduct create(WishlistProduct wishlistProduct) {
        return wishlistProductRepository.save(wishlistProduct);
    }

    @Override
    public WishlistProduct read(Long aLong) {
        return wishlistProductRepository.findById(aLong).orElseThrow(() -> new IllegalStateException("Wishlist product with id "
                + aLong +" not found"));
    }

    @Override
    public WishlistProduct update(WishlistProduct wishlistProduct) {
        if (wishlistProductRepository.existsById(wishlistProduct.getWishlistProductId())){
            return wishlistProductRepository.save(wishlistProduct);
        } else {
            throw new IllegalStateException("Wishlist product with id " + wishlistProduct.getWishlistProductId() + " not found");
        }
    }

    @Override
    public boolean delete(Long d) {
        if (wishlistProductRepository.existsById(d)){
            wishlistProductRepository.deleteById(d);
            return true;
        } else {
            throw new IllegalStateException("Wishlist product with id " + d + " not found");
        }
    }

    @Override
    public List<WishlistProduct> getAll() {
        return wishlistProductRepository.findAll();
    }
}
