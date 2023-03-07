package com.example.firstapp.security.controllers;

import com.example.firstapp.security.controllers.dto.LoginDto;
import com.example.firstapp.security.jwt.JwtProvider;
import com.example.firstapp.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api-firstapp/auth")
@CrossOrigin(origins = {"*"})
public class AuthController {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private JwtProvider provider;

    @PostMapping("/loggin")
    public ResponseEntity<CustomResponse<Map<String, Object>>> login(
            @Valid @RequestBody LoginDto login){
        Authentication authentication = manager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = provider.generateToken(authentication);
        UserDetails userDetails= (UserDetails) authentication.getPrincipal();
        Map<String, Object> data = new HashMap<>();
        data.put("token", token);
        data.put("user", userDetails);
        return new ResponseEntity<>(
                new CustomResponse<>(data,false,200,"Ok"), HttpStatus.OK
        );
    }
}
