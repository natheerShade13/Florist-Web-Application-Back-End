package za.ac.cput.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import za.ac.cput.dto.AuthenticationRequestDto;
import za.ac.cput.dto.AuthenticationResponseDto;
import za.ac.cput.security.repository.UserRepository;
import za.ac.cput.security.jwt.JWTService;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final JWTService jwtService;
    private  final AuthenticationManager authenticationManager;

    public AuthenticationResponseDto authenticate(AuthenticationRequestDto authenticationRequestDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequestDto.getEmail(),
                authenticationRequestDto.getPassword()));
        var user = userRepository.findByEmail(authenticationRequestDto.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseDto.builder()
                .token(jwtToken)
                .build();
    }

}
