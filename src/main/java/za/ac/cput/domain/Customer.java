package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private Long customerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email")
    private Contact contact;

    public Customer() {
    }

    public Customer(Builder builder) {
        this.customerId = builder.build().customerId;
        this.firstName = builder.firstName;
        this.lastname = builder.lastname;
        this.contact = builder.contact;
    }

    public Long getId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public Contact getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", contact=" + contact +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId) &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastname, customer.lastname) &&
                Objects.equals(contact, customer.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, firstName, lastname, contact);
    }

    public static class Builder {
        private Long customerId;
        private String firstName;
        private String lastname;
        private Contact contact;

        public Builder() {
        }

        public Builder setId(Long customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
