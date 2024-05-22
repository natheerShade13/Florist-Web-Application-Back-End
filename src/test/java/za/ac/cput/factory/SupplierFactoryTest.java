package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class SupplierFactoryTest {

    @Test
    void buildSupplier() {
        Supplier supplier = SupplierFactory.buildSupplier("76543","John","Doe","johnD@gmail.com","+27664556724");
        assertNotNull(supplier);
        System.out.println(supplier);
    }

    @Test
    void buildSupplierWithFailingData() {
        Supplier supplier = SupplierFactory.buildSupplier("76543","John","Cena","johnCena@gmail.com","+276348748353556724");
        assertNotNull(supplier);
        System.out.println(supplier);
    }

}