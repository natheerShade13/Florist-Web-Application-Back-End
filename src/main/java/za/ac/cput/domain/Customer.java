package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

//Must add Auto Generate ID, Cascade, Column names and nullable true/false to all entities;
//What should the relationship be between Orders and Coupon be?;
//Should supplier be a company name or individual name and surname, is an address needed as well???;
//Check all entity attributes;
//Should Customer or Cart have the OneToOne mapping?;
//Should Product have the foreign key instead of review?;
//Coupon needs a boolean variable called isUsed;

@Entity
public class Customer implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUS_ID")
    private long customerId;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    private String mobileNumber;
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;
    @OneToMany(mappedBy = "customer")
    private List<Orders> orders;
    @OneToMany(mappedBy = "customer")
    private List<Review> reviews;
    @OneToOne(mappedBy = "customer") //fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true
    private Cart cart;

    protected Customer(){}

    private Customer(Builder builder){
        this.customerId = builder.customerId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
        this.mobileNumber = builder.mobileNumber;
        this.dateOfBirth = builder.dateOfBirth;
        this.role = builder.role;
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getFirstName() {return firstName;}

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {return email;}

    public String getMobileNumber() {return mobileNumber;}

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(email, customer.email) && Objects.equals(password, customer.password) && Objects.equals(mobileNumber, customer.mobileNumber) && Objects.equals(dateOfBirth, customer.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, firstName, lastName, email, password, mobileNumber, dateOfBirth);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    public static class Builder{
        private long customerId;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String mobileNumber;
        private LocalDate dateOfBirth;
        private Role role;

        public Builder setCustomerId(long customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public Builder setRole(Role role) {
            this.role = role;
            return this;
        }

        public Builder copy(Customer customer){
            this.customerId = customer.customerId;
            this.firstName = customer.firstName;
            this.lastName = customer.lastName;
            this.email = customer.email;
            this.password = customer.password;
            this.mobileNumber = customer.mobileNumber;
            this.dateOfBirth = customer.dateOfBirth;
            return this;
        }

        public Customer build(){return new Customer(this);}

    }

}
