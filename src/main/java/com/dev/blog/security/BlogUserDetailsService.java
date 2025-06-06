package com.dev.blog.security;

import com.dev.blog.domain.entities.User;
import com.dev.blog.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class BlogUserDetailsService implements UserDetailsService {

   private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " not found!"));

       return new BlogUserDetails(user);

    }
}
