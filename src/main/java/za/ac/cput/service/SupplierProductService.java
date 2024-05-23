package za.ac.cput.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.SupplierProduct;
import za.ac.cput.repository.SupplierProductRepository;


import java.util.List;

@Service
public class SupplierProductService implements ISupplierProductService {

    SupplierProductRepository repository;

    @Autowired
    public SupplierProductService(SupplierProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public SupplierProduct create(SupplierProduct supplierProduct) {
        return repository.save(supplierProduct);
    }

    @Override
    public SupplierProduct read(String s) {
        return repository.findById(s).orElse(null);
    }

    @Override
    public SupplierProduct update(SupplierProduct supplierProduct) {
        return repository.save(supplierProduct);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<SupplierProduct> getAll() {
        return repository.findAll();
    }
}
