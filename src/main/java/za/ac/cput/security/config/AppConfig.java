package za.ac.cput.security.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Role;
import za.ac.cput.service.CustomerService;

@Configuration
public class AppConfig {

    private final PasswordEncoder passwordEncoder;

    public AppConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public CommandLineRunner initDefaultAdmin(CustomerService customerService) {
        return args -> {
            // Check if the default admin exists
            if (customerService.getCustomer("admin@florist.com") == null) {
                Customer customer = new Customer.Builder()
                        .setFirstName("admin")
                        .setLastName("admin")
                        .setEmail("admin@florist.com")
                        .setPassword(passwordEncoder.encode("admin"))
                        .setRole(Role.ADMIN)
                        .build();
                customerService.create(customer);
            }
        };
    }
}
