package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Entity
public class SupplierProduct {
    @Id
    private String supplierProductId;
    private double supplyPrice;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    protected SupplierProduct() {
    }

    private SupplierProduct(Builder builder) {
        this.supplyPrice = builder.supplyPrice;
        this.supplierProductId = builder.supplierProductId;

    }

    public String getSupplierProductId() {
        return supplierProductId;
    }

    public double getSupplyPrice() {
        return supplyPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierProduct that = (SupplierProduct) o;
        return Double.compare(supplyPrice, that.supplyPrice) == 0 && Objects.equals(supplierProductId, that.supplierProductId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierProductId, supplyPrice);
    }

    @Override
    public String toString() {
        return "SupplierProduct{" +
                "supplierProductId='" + supplierProductId + '\'' +
                ", supplyPrice=" + supplyPrice +
                '}';
    }

    public static class Builder {
        private String supplierProductId;
        private double supplyPrice;

        public Builder setSupplierProductId(String supplierProductId) {
            this.supplierProductId = supplierProductId;
            return this;
        }

        public Builder setSupplyPrice(double supplyPrice) {
            this.supplyPrice = supplyPrice;
            return this;
        }

        public Builder copy(SupplierProduct supplierProduct) {
            this.supplyPrice = supplierProduct.supplyPrice;
            this.supplierProductId = supplierProduct.supplierProductId;
            return this;
        }

        public SupplierProduct build() {
            return new SupplierProduct(this);
        }
    }
}
