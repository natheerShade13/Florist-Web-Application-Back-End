package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
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

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SupplierProductServiceTest {

    @Autowired
    private SupplierProductService supplierProductService;
    @Autowired
    private ProductService productService;
    @Autowired
    private SupplierService supplierService;

    private static Supplier supplier;
    private static Product product;
    private static SupplierProduct supplierProduct;

    @Test
    @Order(0)
    void setup(){
        supplier = SupplierFactory.buildSupplier(1, "Jacks", "Toys"
                , "JacksToys@gmail.com", "0677784626");
        String imageUrl = "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=";
        product = ProductFactory.buildProduct(1, "Jalapeno", "Red hot jalapeno"
                , 50, imageUrl, 5, "Plant");
        supplierProduct = SupplierProductFactory.buildSupplierProduct(1, supplier, product
                ,5, 30, LocalDate.of(2024, Month.JANUARY, 10));
    }

    @Test
    @Order(1)
    void create() {
        Supplier createSupplier = supplierService.create(supplier);
        assertNotNull(createSupplier);
        System.out.println(createSupplier);
        Product createProduct = productService.create(product);
        assertNotNull(createProduct);
        System.out.println(createProduct);
        SupplierProduct createSupplierProduct = supplierProductService.create(supplierProduct);
        assertNotNull(createSupplierProduct);
        System.out.println(createSupplierProduct);
    }

    @Test
    @Order(2)
    void read() {
        SupplierProduct findSupplierProduct = supplierProductService.read(supplierProduct.getSupplierProductId());
        assertNotNull(findSupplierProduct);
        System.out.println(findSupplierProduct);
    }

    @Test
    @Order(3)
    void update() {
        SupplierProduct newSupplierProduct = new SupplierProduct.Builder().copy(supplierProduct)
                .setSupplyDate(LocalDate.of(2024, Month.JANUARY, 25)).build();
        assertNotNull(newSupplierProduct);
        SupplierProduct updateSupplierProduct = supplierProductService.update(newSupplierProduct);
        assertNotNull(updateSupplierProduct);
        System.out.println(updateSupplierProduct);
    }

    @Test
    @Order(5)
    void delete() {
        boolean deleteSupplierProduct = supplierProductService.delete(supplierProduct.getSupplierProductId());
        assertTrue(deleteSupplierProduct);
        System.out.println(deleteSupplierProduct);

    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(supplierProductService.getAll());
    }
}