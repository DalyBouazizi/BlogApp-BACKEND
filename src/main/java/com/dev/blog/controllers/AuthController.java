package com.dev.blog.controllers;

import com.dev.blog.domain.dtos.AuthResponse;
import com.dev.blog.domain.dtos.LoginRequest;
import com.dev.blog.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;


    @PostMapping
    public ResponseEntity<AuthResponse> login (@RequestBody LoginRequest loginRequest) {
        UserDetails user = authenticationService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());
        String token = authenticationService.generatetoken(user);
        AuthResponse Auth =  AuthResponse.builder()
                .token(token)
                .expiresIn(86400)
                .build();
                return ResponseEntity.ok(Auth);
    }
}
