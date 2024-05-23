package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Supplier;
import za.ac.cput.repository.SupplierRepository;

import java.util.List;

@Service
public class SupplierService implements ISupplierService {

    SupplierRepository repository;

    @Autowired
    public SupplierService(SupplierRepository repository) {
        this.repository = repository;
    }

    @Override
    public Supplier create(Supplier supplier) {
        return repository.save(supplier);
    }

    @Override
    public Supplier read(String s) {
        return repository.findById(s).orElse(null);
    }

    @Override
    public Supplier update(Supplier supplier) {
        return repository.save(supplier);
    }

    @Override
    public List<Supplier> getAll() {
        return repository.findAll();
    }
}
