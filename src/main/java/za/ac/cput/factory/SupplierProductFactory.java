package za.ac.cput.factory;

import za.ac.cput.domain.Product;
import za.ac.cput.domain.Supplier;
import za.ac.cput.domain.SupplierProduct;
import za.ac.cput.utility.ProductHelper;
import za.ac.cput.utility.SupplierHelper;

public class SupplierProductFactory {

    public static SupplierProduct buildSupplierProduct(String supplierProductId, double supplyPrice, Product product, Supplier supplier) {
        if (SupplierHelper.isNullorEmpty(supplierProductId) ||
                !ProductHelper.isValidPrice(supplyPrice)
                || supplier == null || product == null
        )


            return null;

        return new SupplierProduct.Builder().setSupplierProductId(supplierProductId).setSupplyPrice(supplyPrice).setProduct(product).setSupplier(supplier).build();
    }
}
