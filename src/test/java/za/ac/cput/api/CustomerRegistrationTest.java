package za.ac.cput.api;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Customer;
import za.ac.cput.dto.UserDto;
import za.ac.cput.factory.CustomerFactory;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerRegistrationTest {

    @Autowired
    private CustomerRegistration customerRegistration;

    private static UserDto user;

    @Test
    @Order(0)
    void setUp() {
        user = UserDto.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@doe.com")
                .password("password")
                .build();
    }

    @Test
    @Order(1)
    void registerCustomer() {
        Customer registerCustomer = customerRegistration.registerCustomer(user);
        assertNotNull(registerCustomer);
        System.out.println(registerCustomer);
    }
}