package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.CartProduct;
import za.ac.cput.repository.CartProductRepository;

import java.util.List;

@Service
public class CartProductService implements IService<CartProduct, Long>{

    @Autowired
    private final CartProductRepository cartProductRepository;

    public CartProductService(CartProductRepository cartProductRepository) {
        this.cartProductRepository = cartProductRepository;
    }

    @Override
    public CartProduct create(CartProduct cartProduct) {
        return cartProductRepository.save(cartProduct);
    }

    @Override
    public CartProduct read(Long aLong) {
        return cartProductRepository.findById(aLong).orElseThrow(() -> new IllegalStateException(
                "CartProduct with" + " id " + aLong + " does not exist"));
    }

    @Override
    public CartProduct update(CartProduct cartProduct) {
        if (cartProductRepository.existsById(cartProduct.getCartProductId())){
            return cartProductRepository.save(cartProduct);
        } else {
            throw new IllegalStateException("CartProduct with id " + cartProduct.getCartProductId()
                    + " does not exist");
        }
    }

    @Override
    public boolean delete(Long d) {
        if (cartProductRepository.existsById(d)){
            cartProductRepository.deleteById(d);
            return true;
        } else {
            throw new IllegalStateException("CartProduct with id " + d + " does not exist");
        }
    }

    @Override
    public List<CartProduct> getAll() {
        return cartProductRepository.findAll();
    }
}
