package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Supplier;
import za.ac.cput.domain.SupplierProduct;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class SupplierProductFactoryTest {

    private Supplier supplier;
    private Product product;
    private SupplierProduct supplierProductA;
    private SupplierProduct supplierProductB;

    @Test
    void buildSupplierProduct() {
        supplier = SupplierFactory.buildSupplier(1, "Jacks", "Toys"
                , "JacksToys@gmail.com", "0677784626");
        String imageUrl = "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=";
        product = ProductFactory.buildProduct( "Jalapeno", "Red hot jalapeno"
                , 50, imageUrl, 5, "Plant");
        supplierProductA = SupplierProductFactory.buildSupplierProduct(1, supplier, product
                ,5, 30, LocalDate.of(2024, Month.JANUARY, 10));
        assertNotNull(supplierProductA);
        System.out.println(supplierProductA);
    }

    @Test
    void buildSupplierProductFail() {
        supplier = SupplierFactory.buildSupplier(1, "Jacks", "Toys"
                , "JacksToys@gmail.com", "0677784626");
        String imageUrl = "https://media.istockphoto.com/id/174655938/photo/rose-background.webp?s=1024x1024&w=is&k=20&c=pGDOZrqVKxiYK46Ts9bcGwmhXVFPpGaJ3NI4F_kUVgE=";
        product = ProductFactory.buildProduct("Jalapeno", "Red hot jalapeno"
                , 50, imageUrl, 5, "Plant");
        supplierProductB = SupplierProductFactory.buildSupplierProduct(1, supplier, product
                ,0, 30, LocalDate.of(2024, Month.JANUARY, 10));
        assertNotNull(supplierProductB);
        System.out.println(supplierProductB);
    }

}