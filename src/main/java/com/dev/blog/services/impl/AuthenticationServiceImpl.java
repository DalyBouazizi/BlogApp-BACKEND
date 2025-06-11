package com.dev.blog.services.impl;

import com.dev.blog.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    @Value("${jwt.secret}")
    private String secretKey;

    private final long jwtExpirationMs = 86400000L ;

    @Override
    public UserDetails authenticate(String email, String password) {
        return null;
    }

    @Override
    public String generatetoken(UserDetails userDetails) {
        return "";
    }
}
