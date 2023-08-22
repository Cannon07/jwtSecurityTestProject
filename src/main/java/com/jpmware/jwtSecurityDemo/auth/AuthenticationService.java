package com.jpmware.jwtSecurityDemo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jpmware.jwtSecurityDemo.config.JwtService;
import com.jpmware.jwtSecurityDemo.user.Role;
import com.jpmware.jwtSecurityDemo.user.User;
import com.jpmware.jwtSecurityDemo.user.UserRepository;

@Service
public class AuthenticationService {

    private UserRepository repository;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationService(
        UserRepository userRepository, 
        PasswordEncoder passwordEncoder,
        JwtService jwtService,
        AuthenticationManager authenticationManager
    ) {
        repository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }
    
    public AuthenticationResponse register(RegisterRequest request) {
        User user = new User(
            request.getFirstName(), 
            request.getLastName(), 
            request.getEmail(),
            passwordEncoder.encode(request.getPassword()),
            Role.ADMIN
        );
        repository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(), 
                request.getPassword())
        );
        User user = repository.findByEmail(request.getEmail())
            .orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }
}
