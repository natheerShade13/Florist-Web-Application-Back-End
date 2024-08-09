package za.ac.cput.factory;

import za.ac.cput.domain.Product;
import za.ac.cput.domain.Supplier;
import za.ac.cput.domain.SupplierProduct;
import za.ac.cput.util.SupplierProductHelper;

import java.time.LocalDate;

public class SupplierProductFactory {

    public static SupplierProduct buildSupplierProduct(long supplierProductId, Supplier supplier, Product product
            , int quantity, double supplyPrice, LocalDate supplyDate){
        if (SupplierProductHelper.validId(supplierProductId) || supplier == null || product == null
                || SupplierProductHelper.isLessThanZero(quantity) || SupplierProductHelper.isNegative(supplyPrice)
                || SupplierProductHelper.isNull(supplyDate)){
                    return null;
        }

        return new SupplierProduct.Builder().setSupplierProductId(supplierProductId).setSupplier(supplier)
                .setProduct(product).setQuantity(quantity).setSupplyPrice(supplyPrice).setSupplyDate(supplyDate)
                .build();
    }

}
