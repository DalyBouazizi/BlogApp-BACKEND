package com.dev.blog.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationService {

    UserDetails authenticate(String email, String password);
    String generatetoken(UserDetails userDetails);
    UserDetails validateToken(String token);
}
