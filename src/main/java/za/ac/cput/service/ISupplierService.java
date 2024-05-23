package za.ac.cput.service;

import za.ac.cput.domain.Supplier;

import java.util.List;

public interface ISupplierService extends IService<Supplier, String> {

    List<Supplier> getAll();
}
