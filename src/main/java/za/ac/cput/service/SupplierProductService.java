package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.SupplierProduct;
import za.ac.cput.repository.SupplierProductRepository;

import java.util.List;

@Service
public class SupplierProductService implements IService<SupplierProduct, Long>{

    @Autowired
    private final SupplierProductRepository supplierProductRepository;

    public SupplierProductService(SupplierProductRepository supplierProductRepository) {
        this.supplierProductRepository = supplierProductRepository;
    }

    @Override
    public SupplierProduct create(SupplierProduct supplierProduct) {
        return supplierProductRepository.save(supplierProduct);
    }

    @Override
    public SupplierProduct read(Long aLong) {
        return supplierProductRepository.findById(aLong).orElseThrow(() -> new IllegalStateException("Supplier" +
                "Product with Id " + aLong + " does not exist"));
    }

    @Override
    public SupplierProduct update(SupplierProduct supplierProduct) {
        if (supplierProductRepository.existsById(supplierProduct.getSupplierProductId())){
            return supplierProductRepository.save(supplierProduct);
        } else {
            throw new IllegalStateException("SupplierProduct with Id " + supplierProduct.getSupplierProductId()
                    + " does not exist");
        }
    }

    @Override
    public boolean delete(Long d) {
        if (supplierProductRepository.existsById(d)){
            supplierProductRepository.deleteById(d);
            return true;
        } else {
            throw new IllegalStateException("SupplierProduct with Id " + d + " does not exist");
        }
    }

    @Override
    public List<SupplierProduct> getAll() {
        return supplierProductRepository.findAll();
    }
}
