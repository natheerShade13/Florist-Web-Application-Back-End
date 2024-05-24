package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Supplier;
import za.ac.cput.domain.SupplierProduct;

import static org.junit.jupiter.api.Assertions.*;

class SupplierProductFactoryTest {
    String imageUrl = "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=";
    Product product = ProductFactory.buildProduct("12345", "Roses", "Filled With yooh", 25.00f, imageUrl);
    Supplier supplier = SupplierFactory.buildSupplier("76543", "John", "Doe", "johnD@gmail.com", "+27664556724");

    @Test
    void buildSupplierProduct() {
        SupplierProduct supplierProduct = SupplierProductFactory.buildSupplierProduct("2", 50.00f, product, supplier);
        assertNotNull(supplierProduct);
        System.out.println(supplierProduct);
    }

    @Test
    void buildSupplierProductWithFailingData() {
        SupplierProduct supplierProduct = SupplierProductFactory.buildSupplierProduct("3", 0.00f, product, supplier);
        assertNotNull(supplierProduct);
        System.out.println(supplierProduct);
    }
}