package com.dev.blog.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationService {

    UserDetails authenticate(String email, String password);
    String generatetoken(UserDetails userDetails);
}
