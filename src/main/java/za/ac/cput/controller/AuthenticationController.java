package za.ac.cput.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.service.AdminService;
import za.ac.cput.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AdminService adminService;
    private final CustomerService customerService;
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        // Log the received values
        logger.info("Received login request with email: {} and password: {}", email, password);

        if (adminService.verifyLogin(email, password)) {
            // Log successful admin login
            logger.info("Admin login successful for email: {}", email);
            return new ResponseEntity<>("Admin", HttpStatus.OK);
        } else if (customerService.verifyLogin(email, password)) {
            // Log successful customer login
            logger.info("Customer login successful for email: {}", email);
            return new ResponseEntity<>("Customer", HttpStatus.OK);
        } else {
            // Log failed login attempt
            logger.warn("Failed login attempt for email: {}", email);
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }
    }
}
