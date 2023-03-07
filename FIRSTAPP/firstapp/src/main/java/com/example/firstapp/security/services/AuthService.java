package com.example.firstapp.security.services;

import com.example.firstapp.security.model.UserAuth;
import com.example.firstapp.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthService implements UserDetailsService {
    @Autowired
    UserService service;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return UserAuth.build(service.getUserByUsername(username));
    }
}
