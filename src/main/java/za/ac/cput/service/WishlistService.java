package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Wishlist;
import za.ac.cput.repository.WishlistRepository;

import java.util.List;

@Service
public class WishlistService implements IService<Wishlist, Long>{

    @Autowired
    private final WishlistRepository wishlistRepository;

    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    @Override
    public Wishlist create(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    @Override
    public Wishlist read(Long aLong) {
        return wishlistRepository.findById(aLong).orElseThrow(() -> new IllegalStateException("Wishlist with id "
                + aLong +" not found"));
    }

    @Override
    public Wishlist update(Wishlist wishlist) {
        if (wishlistRepository.existsById(wishlist.getWishListId())){
            return wishlistRepository.save(wishlist);
        }else {
            throw new IllegalStateException("Wishlist with id " + wishlist.getWishListId() + " not found");
        }
    }

    @Override
    public boolean delete(Long d) {
        if (wishlistRepository.existsById(d)){
            wishlistRepository.deleteById(d);
            return true;
        } else {
            throw new IllegalStateException("Wishlist with id " + d + " not found");
        }
    }

    @Override
    public List<Wishlist> getAll() {
        return wishlistRepository.findAll();
    }
}
