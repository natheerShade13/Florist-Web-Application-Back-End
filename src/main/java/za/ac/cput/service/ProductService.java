package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Product;
import za.ac.cput.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService implements IService<Product, Long>{


    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product read(Long aLong) {
        return productRepository.findById(aLong).orElseThrow(()-> new IllegalStateException("Product with " +
                "Id " + aLong + " does not exist"));
    }

    @Override
    public Product update(Product product) {
        if (productRepository.existsById(product.getProductId())){
            return productRepository.save(product);
        } else {
            throw new IllegalStateException("Product with Id " + product.getProductId() + " does not exist");
        }
    }

    @Override
    public boolean delete(Long d) {
        if (productRepository.existsById(d)){
            productRepository.deleteById(d);
            return true;
        } else {
            throw new IllegalStateException("Product with Id " + d + " does not exist");
        }
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
