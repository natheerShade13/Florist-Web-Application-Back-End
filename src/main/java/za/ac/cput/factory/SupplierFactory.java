package za.ac.cput.factory;

import za.ac.cput.domain.Supplier;
import za.ac.cput.utility.SupplierHelper;

public class SupplierFactory {
    public static Supplier buildSupplier(String supplierId, String firstName, String lastName, String email, String phoneNumber) {
        if (SupplierHelper.isNullorEmpty(supplierId) ||
                SupplierHelper.isNullorEmpty(firstName) ||
                SupplierHelper.isNullorEmpty(lastName) ||
                !SupplierHelper.isValidEmail(email) ||
                !SupplierHelper.isValidPhoneNumber(phoneNumber))
            return null;

        return new Supplier.Builder().setSupplierID(supplierId).setFirstName(firstName).setLastName(lastName).setEmail(email).setPhoneNumber(phoneNumber).build();

    }
}
