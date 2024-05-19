package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private long employeeId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages;

    // Private constructor to enforce the use of the builder
    private Employee(Builder builder) {
        this.employeeId = builder.employeeId;
        this.name = builder.name;
        this.email = builder.email;
        this.address = builder.address;
        this.phone = builder.phone;
        this.role = builder.role;
        this.messages = builder.messages;
    }

    // Default constructor for JPA
    public Employee() {}

    // Getters for each field
    public long getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getRole() {
        return role;
    }

    public List<Message> getMessages() {
        return messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId) &&
                Objects.equals(name, employee.name) &&
                Objects.equals(email, employee.email) &&
                Objects.equals(address, employee.address) &&
                Objects.equals(phone, employee.phone) &&
                Objects.equals(role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, name, email, address, phone, role);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", role='" + role + '\'' +
                ", messages=" + messages +
                '}';
    }

    // Builder class
    public static class Builder {
        private long employeeId;
        private String name;
        private String email;
        private String address;
        private String phone;
        private String role;
        private List<Message> messages;

        // Setter methods for each field returning Builder for chaining
        public Builder setEmployeeId(long employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setRole(String role) {
            this.role = role;
            return this;
        }

        public Builder setMessages(List<Message> messages) {
            this.messages = messages;
            return this;
        }

        public Builder copy(Employee employee) {
            this.employeeId = employee.employeeId;
            this.name = employee.name;
            this.email = employee.email;
            this.address = employee.address;
            this.phone = employee.phone;
            this.role = employee.role;
            this.messages = employee.messages;
            return this;
        }

        // Build method to create an instance of Employee
        public Employee build() {
            return new Employee(this);
        }
    }
}
