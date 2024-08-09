package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Customer;
import za.ac.cput.util.AddressHelper;

public class AddressFactory {

    public static Address buildAddress(long addressId, String streetNumber, String streetName,
                                       String suburb, String postalCode, String city, Customer customer){
        if (AddressHelper.validId(addressId) || AddressHelper.isNullOrEmpty(streetNumber)
                || AddressHelper.isNullOrEmpty(streetName) || AddressHelper.isNullOrEmpty(suburb)
                || AddressHelper.isNullOrEmpty(postalCode) || AddressHelper.isNullOrEmpty(city)
                || customer == null){
            return null;
        }

        return new Address.Builder().setAddressId(addressId).setStreetNumber(streetNumber).setStreetName(streetName)
                .setSuburb(suburb).setPostalCode(postalCode).setCity(city).setCustomer(customer).build();
    }
}
