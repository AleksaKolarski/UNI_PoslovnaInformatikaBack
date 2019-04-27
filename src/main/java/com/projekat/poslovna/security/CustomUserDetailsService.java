package com.projekat.poslovna.security;

import com.projekat.poslovna.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> user = userService.findByEmail(username);
        if (user.isPresent()) {
        	return user.get();
        } else {
            return null;
        }
    }

    public boolean changePassword(String oldPassword, String newPassword) {
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        String username = currentUser.getName();
        if (authenticationManager != null) {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, oldPassword));
        } else {
            return false;
        }
        User user = (User) loadUserByUsername(username);
        if(user == null) {
        	return false;
        }
        user.setPassword(passwordEncoder.encode(newPassword));
        user = userService.save(user);
        if(user == null) {
        	return false;
        }
        return true;
    }
}