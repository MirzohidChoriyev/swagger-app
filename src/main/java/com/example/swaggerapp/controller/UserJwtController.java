package com.example.swaggerapp.controller;

import com.example.swaggerapp.entity.User;
import com.example.swaggerapp.repository.UserRepository;
import com.example.swaggerapp.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class UserJwtController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginVM loginVM){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginVM.getUsername(), loginVM.getPassword()));
        User user = userRepository.findByUsername(loginVM.getUsername());
        if(user == null){
            return ResponseEntity.ok("Bunaqa user mavjud emas");
        }
        String token = jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
        Map<Object, Object> map = new HashMap<>();
        map.put("username", user.getUsername());
        map.put("token", token);
        return ResponseEntity.ok(map);
    }
}
