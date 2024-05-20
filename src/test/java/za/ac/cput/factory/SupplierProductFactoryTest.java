package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.SupplierProduct;

import static org.junit.jupiter.api.Assertions.*;

class SupplierProductFactoryTest {

    @Test
    void buildSupplierProduct() {
        SupplierProduct supplierProduct = SupplierProductFactory.buildSupplierProduct("2",50.00f);
        assertNotNull(supplierProduct);
        System.out.println(supplierProduct);
    }
    @Test
    void buildSupplierProductWithFailingData() {
        SupplierProduct supplierProduct = SupplierProductFactory.buildSupplierProduct("3",0.00f);
        assertNotNull(supplierProduct);
        System.out.println(supplierProduct);
    }
}