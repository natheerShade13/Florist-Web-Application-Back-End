package za.ac.cput.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
//Can also be called employee
@Table(name = "admins")
public class Admin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "admin_id")
    private long adminId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role; // ADMIN"

    protected Admin() {}


    private Admin(Builder builder) {
        this.adminId = builder.adminId;
        this.email = builder.email;
        this.password = builder.password;
        this.role = builder.role;
    }

    // Getters
    public long getAdminId() {
        return adminId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return adminId == admin.adminId &&
                Objects.equals(email, admin.email) &&
                Objects.equals(password, admin.password) &&
                Objects.equals(role, admin.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId, email, password, role);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public static class Builder {
        private long adminId;
        private String email;
        private String password;
        private String role;

        public Builder setAdminId(long adminId) {
            this.adminId = adminId;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setRole(String role) {
            this.role = role;
            return this;
        }

        public Builder copy(Admin admin) {
            this.adminId = admin.adminId;
            this.email = admin.email;
            this.password = admin.password;
            this.role = admin.role;
            return this;
        }

        public Admin build() {
            return new Admin(this);
        }
    }
}
