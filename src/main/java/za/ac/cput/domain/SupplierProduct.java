package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class SupplierProduct {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long supplierProductId;
    @ManyToOne
    @JoinColumn(name = "SUPPLIER_ID")
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
    private int quantity;
    private double supplyPrice;
    private LocalDate supplyDate;

    protected SupplierProduct() {
    }

    private SupplierProduct(Builder builder) {
        this.supplierProductId = builder.supplierProductId;
        this.product = builder.product;
        this.supplier = builder.supplier;
        this.quantity = builder.quantity;
        this.supplyPrice = builder.supplyPrice;
        this.supplyDate = builder.supplyDate;
    }

    public long getSupplierProductId() {
        return supplierProductId;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSupplyPrice() {
        return supplyPrice;
    }

    public LocalDate getSupplyDate() {
        return supplyDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierProduct that = (SupplierProduct) o;
        return quantity == that.quantity && Double.compare(supplyPrice, that.supplyPrice) == 0 && Objects.equals(supplierProductId, that.supplierProductId) && Objects.equals(supplier, that.supplier) && Objects.equals(product, that.product) && Objects.equals(supplyDate, that.supplyDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierProductId, supplier, product, quantity, supplyPrice, supplyDate);
    }

    @Override
    public String toString() {
        return "SupplierProduct{" +
                "supplierProductId=" + supplierProductId +
                ", supplier=" + supplier +
                ", product=" + product +
                ", quantity=" + quantity +
                ", supplyPrice=" + supplyPrice +
                ", supplyDate=" + supplyDate +
                '}';
    }

    public static class Builder {

        private long supplierProductId;
        private Supplier supplier;
        private Product product;
        private int quantity;
        private double supplyPrice;
        private LocalDate supplyDate;

        public Builder setSupplierProductId(long supplierProductId) {
            this.supplierProductId = supplierProductId;
            return this;
        }

        public Builder setSupplier(Supplier supplier) {
            this.supplier = supplier;
            return this;
        }

        public Builder setProduct(Product product) {
            this.product = product;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setSupplyPrice(double supplyPrice) {
            this.supplyPrice = supplyPrice;
            return this;
        }

        public Builder setSupplyDate(LocalDate supplyDate) {
            this.supplyDate = supplyDate;
            return this;
        }

        public Builder copy(SupplierProduct supplierProduct) {
            this.supplierProductId = supplierProduct.supplierProductId;
            this.product = supplierProduct.product;
            this.supplier = supplierProduct.supplier;
            this.quantity = supplierProduct.quantity;
            this.supplyPrice = supplierProduct.supplyPrice;
            this.supplyDate = supplierProduct.supplyDate;
            return this;
        }

        public SupplierProduct build() {
            return new SupplierProduct(this);
        }
    }

}
