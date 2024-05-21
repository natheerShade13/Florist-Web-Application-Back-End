package za.ac.cput.factory;

import za.ac.cput.domain.SupplierProduct;
import za.ac.cput.utility.ProductHelper;
import za.ac.cput.utility.SupplierHelper;

public class SupplierProductFactory {

    public static SupplierProduct buildSupplierProduct(String supplierProductId, double supplyPrice) {
        if (SupplierHelper.isNullorEmpty(supplierProductId) ||
                !ProductHelper.isValidPrice(supplyPrice))
            return null;

        return new SupplierProduct.Builder().setSupplierProductId(supplierProductId).setSupplyPrice(supplyPrice).build();
    }
}
