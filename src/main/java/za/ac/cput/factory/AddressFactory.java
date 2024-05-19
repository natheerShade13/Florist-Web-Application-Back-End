package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.utility.AddressHelper;

public class AddressFactory {
    public static Address createAddress(String streetNumber, String streetName, String suburb, String city, String zipCode, String province) {
        if (AddressHelper.isStringNullOrEmpty(streetNumber)
                || AddressHelper.isStringNullOrEmpty(streetName)
                || AddressHelper.isStringNullOrEmpty(suburb)
                || AddressHelper.isStringNullOrEmpty(city)
                || AddressHelper.isStringNullOrEmpty(zipCode)
                || AddressHelper.isStringNullOrEmpty(province)) {
            return null;
        }

        long addressId = AddressHelper.generateUniqueID();
        return new Address.Builder()
                .setAddressId(addressId)
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setSuburb(suburb)
                .setCity(city)
                .setZipCode(zipCode)
                .setProvince(province)
                .build();
    }

    public static Address createAddress(long addressId, String streetNumber, String streetName, String suburb, String city, String zipCode, String province) {
        if (AddressHelper.isStringNullOrEmpty(streetNumber)
                ||addressId<0
                || AddressHelper.isStringNullOrEmpty(streetName)
                || AddressHelper.isStringNullOrEmpty(suburb)
                || AddressHelper.isStringNullOrEmpty(city)
                || AddressHelper.isStringNullOrEmpty(zipCode)
                || AddressHelper.isStringNullOrEmpty(province)) {
            return null;
        }

        return new Address.Builder()
                .setAddressId(addressId)
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setSuburb(suburb)
                .setCity(city)
                .setZipCode(zipCode)
                .setProvince(province)
                .build();
    }
}
