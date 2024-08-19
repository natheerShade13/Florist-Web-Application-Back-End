package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class SupplierFactoryTest {

    private Supplier supplierA;
    private Supplier supplierB;

    @Test
    void buildSupplier() {
        supplierA = SupplierFactory.buildSupplier(1, "Jacks", "Toys"
                , "JacksToys@gmail.com", "0677784626");
        assertNotNull(supplierA);
        System.out.println(supplierA);
    }

    @Test
    void buildSupplierFail() {
        supplierB = SupplierFactory.buildSupplier(1, "Jacks", "Toys"
                , "JacksToys", "06777844626");
        assertNotNull(supplierB);
        System.out.println(supplierB);
    }

}