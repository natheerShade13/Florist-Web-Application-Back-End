package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Supplier;
import za.ac.cput.factory.SupplierFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SupplierServiceTest {

    @Autowired
    private SupplierService supplierService;

    private static Supplier supplier;

    @Test
    @Order(0)
    void setUp() {
        supplier = SupplierFactory.buildSupplier(1, "Jacks", "Toys"
                , "JacksToys@gmail.com", "0677784626");
    }

    @Test
    @Order(1)
    void create() {
        Supplier createSupplier = supplierService.create(supplier);
        assertNotNull(createSupplier);
        System.out.println(createSupplier);
    }

    @Test
    @Order(2)
    void read() {
        Supplier findSupplier = supplierService.read(supplier.getSupplierID());
        assertNotNull(findSupplier);
        System.out.println(findSupplier);
    }

    @Test
    @Order(3)
    void update() {
        Supplier newSupplier = new Supplier.Builder().copy(supplier).setEmail("Toys@gmail.com").build();
        assertNotNull(newSupplier);
        System.out.println(newSupplier);
        Supplier updateSupplier = supplierService.update(newSupplier);
        assertNotNull(updateSupplier);
        System.out.println(updateSupplier);
    }

    @Test
    @Order(5)
    void delete() {
        boolean deleteSupplier = supplierService.delete(supplier.getSupplierID());
        assertTrue(deleteSupplier);
        System.out.println(deleteSupplier);
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(supplierService.getAll());
    }
}