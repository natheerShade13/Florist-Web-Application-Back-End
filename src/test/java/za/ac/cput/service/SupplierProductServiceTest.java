package za.ac.cput.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Supplier;
import za.ac.cput.domain.SupplierProduct;
import za.ac.cput.factory.ProductFactory;
import za.ac.cput.factory.SupplierFactory;
import za.ac.cput.factory.SupplierProductFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class SupplierProductServiceTest {
    @Autowired
    SupplierProductService service;
    @Autowired
    ProductService productService;
    @Autowired
    SupplierService supplierService;

    String imageUrl = "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=";
    Product product = ProductFactory.buildProduct("12345", "Roses", "Filled With yooh", 25.00f, imageUrl);
    Supplier supplier = SupplierFactory.buildSupplier("76543", "John", "Doe", "johnD@gmail.com", "+27664556724");
    SupplierProduct supplierProduct = SupplierProductFactory.buildSupplierProduct("888", 50.00f, product, supplier);


    @Test
    void a_create() {


        Product product1 = productService.create(product);
        Supplier supplier1 = supplierService.create(supplier);
        SupplierProduct supplierProduct1 = service.create(supplierProduct);
        assertNotNull(supplierProduct1);
        System.out.println(supplierProduct1);


    }

    @Test
    void b_read() {
        SupplierProduct read = service.read(supplierProduct.getSupplierProductId());
        assertNotNull(read);
        System.out.println(read);


    }

    @Test
    void d_update() {
        SupplierProduct supplierProduct1 = new SupplierProduct.Builder().copy(supplierProduct).setSupplyPrice(75.00f).build();
        SupplierProduct updated = service.update(supplierProduct1);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Disabled
    @Test
    void e_delete() {
        service.delete(supplierProduct.getSupplierProductId());
        System.out.println("Deleted SuccessFully");
    }

    @Test
    void f_getAll() {
        System.out.println(service.getAll());
    }
}