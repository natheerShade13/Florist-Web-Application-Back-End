package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SupplierProduct {
    @Id

    private String supplierProductId;
    private double supplyPrice;
}
