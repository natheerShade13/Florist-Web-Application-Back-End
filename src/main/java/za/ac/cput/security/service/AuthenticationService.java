package za.ac.cput.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import za.ac.cput.dto.UserDto;
import za.ac.cput.security.repository.UserRepository;
import za.ac.cput.security.jwt.JWTService;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    public UserDto authenticate(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                email, password));
        var user = userRepository.findByEmail(email).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return UserDto.builder()
                .customerId(user.getCustomerId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .mobileNumber(user.getMobileNumber())
                .dateOfBirth(user.getDateOfBirth())
                .token(jwtToken)
                .build();
    }

}
