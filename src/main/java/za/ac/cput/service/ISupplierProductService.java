package za.ac.cput.service;

import za.ac.cput.domain.SupplierProduct;

import java.util.List;

public interface ISupplierProductService extends IService<SupplierProduct, String> {

    void delete(String id);

    List<SupplierProduct> getAll();

}
