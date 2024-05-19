package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "work_number")
    private String workNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    // Default constructor for JPA
    protected Contact() {}

    // Private constructor to enforce the use of the builder
    private Contact(Builder builder) {
        this.email = builder.email;
        this.mobileNumber = builder.mobileNumber;
        this.workNumber = builder.workNumber;
        this.address = builder.address;
    }

    // Getters for each field
    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return Objects.equals(email, contact.email) &&
                Objects.equals(mobileNumber, contact.mobileNumber) &&
                Objects.equals(workNumber, contact.workNumber) &&
                Objects.equals(address, contact.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, mobileNumber, workNumber, address);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", workNumber='" + workNumber + '\'' +
                ", address=" + address +
                '}';
    }

    // Builder class
    public static class Builder {
        private String email;
        private String mobileNumber;
        private String workNumber;
        private Address address;

        // Setter methods for each field returning Builder for chaining
        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public Builder setWorkNumber(String workNumber) {
            this.workNumber = workNumber;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder copy(Contact contact) {
            this.email = contact.email;
            this.mobileNumber = contact.mobileNumber;
            this.workNumber = contact.workNumber;
            this.address = contact.address;
            return this;
        }

        // Build method to create an instance of Contact
        public Contact build() {
            return new Contact(this);
        }
    }
}
