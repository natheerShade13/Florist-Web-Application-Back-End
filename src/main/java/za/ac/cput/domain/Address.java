package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", nullable = false)
    private long addressId;

    @Column(name = "street_number", nullable = false)
    private String streetNumber;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "suburb", nullable = false)
    private String suburb;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    @Column(name = "province", nullable = false)
    private String province;

    // Default constructor for JPA
    public Address() {}

    // Private constructor to enforce the use of the builder
    private Address(Builder builder) {
        this.addressId = builder.addressId;
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.suburb = builder.suburb;
        this.city = builder.city;
        this.zipCode = builder.zipCode;
        this.province = builder.province;
    }

    // Getters for each field
    public long getAddressId() {
        return addressId;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getProvince() {
        return province;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return addressId == address.addressId &&
                Objects.equals(streetNumber, address.streetNumber) &&
                Objects.equals(streetName, address.streetName) &&
                Objects.equals(suburb, address.suburb) &&
                Objects.equals(city, address.city) &&
                Objects.equals(zipCode, address.zipCode) &&
                Objects.equals(province, address.province);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, streetNumber, streetName, suburb, city, zipCode, province);
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", suburb='" + suburb + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", province='" + province + '\'' +
                '}';
    }

    // Builder class
    public static class Builder {
        private long addressId;
        private String streetNumber;
        private String streetName;
        private String suburb;
        private String city;
        private String zipCode;
        private String province;

        // Setter methods for each field returning Builder for chaining
        public Builder setAddressId(long addressId) {
            this.addressId = addressId;
            return this;
        }

        public Builder setStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder setSuburb(String suburb) {
            this.suburb = suburb;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder setProvince(String province) {
            this.province = province;
            return this;
        }

        public Builder copy(Address address) {
            this.addressId = address.addressId;
            this.streetNumber = address.streetNumber;
            this.streetName = address.streetName;
            this.suburb = address.suburb;
            this.city = address.city;
            this.zipCode = address.zipCode;
            this.province = address.province;
            return this;
        }

        // Build method to create an instance of Address
        public Address build() {
            return new Address(this);
        }
    }
}
