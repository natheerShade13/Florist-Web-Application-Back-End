package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Supplier;
import za.ac.cput.repository.SupplierRepository;

import java.util.List;

@Service
public class SupplierService implements IService<Supplier, Long>{

    @Autowired
    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Supplier create(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier read(Long aLong) {
        return supplierRepository.findById(aLong).orElseThrow(()-> new IllegalStateException("Supplier with id "
                + aLong + " does not exist"));
    }

    @Override
    public Supplier update(Supplier supplier) {
        if (supplierRepository.existsById(supplier.getSupplierID())){
            return supplierRepository.save(supplier);
        } else{
            throw new IllegalStateException("Supplier with id " + supplier.getSupplierID() + " does not exist");
        }
    }

    @Override
    public boolean delete(Long d) {
        if (supplierRepository.existsById(d)){
            supplierRepository.deleteById(d);
            return true;
        } else {
            throw new IllegalStateException("Supplier with id " + d + " does not exist");
        }
    }

    @Override
    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }
}
