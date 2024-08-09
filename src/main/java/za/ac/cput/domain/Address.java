package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Address {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long addressId;
    private String streetNumber;
    private String streetName;
    private String suburb;
    private String postalCode;
    private String city;
    //@Id
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    protected Address(){}

    private Address(Builder builder){
        this.addressId = builder.addressId;
        this.streetNumber = builder.streetNumber;;
        this.streetName = builder.streetName;
        this.suburb = builder.suburb;
        this.postalCode = builder.postalCode;
        this.city = builder.city;
        this.customer = builder.customer;
    }

    public long getAddressId() {
        return addressId;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getCity() {
        return city;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return addressId == address.addressId && Objects.equals(streetNumber, address.streetNumber) && Objects.equals(streetName, address.streetName) && Objects.equals(suburb, address.suburb) && Objects.equals(postalCode, address.postalCode) && Objects.equals(city, address.city) && Objects.equals(customer, address.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, streetNumber, streetName, suburb, postalCode, city, customer);
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", suburb='" + suburb + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", customer=" + customer +
                '}';
    }

    public static class Builder{

        private long addressId;
        private String streetNumber;
        private String streetName;
        private String suburb;
        private String postalCode;
        private String city;
        private Customer customer;

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

        public Builder setPostalCode(String postalCode) {
            this.postalCode = postalCode;
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

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder copy(Address address){
            this.addressId = address.addressId;
            this.streetNumber = address.streetNumber;;
            this.streetName = address.streetName;
            this.suburb = address.suburb;
            this.postalCode = address.postalCode;
            this.city = address.city;
            this.customer = address.customer;
            return this;
        }

        public Address build(){return new Address(this);}

    }

}
