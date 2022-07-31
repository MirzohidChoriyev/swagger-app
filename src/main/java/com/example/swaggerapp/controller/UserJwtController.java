package com.example.swaggerapp.controller;

import com.example.swaggerapp.entity.User;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.repository.UserRepository;
import com.example.swaggerapp.security.JwtTokenProvider;
import com.example.swaggerapp.service.UserService;
import com.example.swaggerapp.utils.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(Paths.return_path)
@RestController
@RequestMapping("/api/")
public class UserJwtController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ApiResponse login(@RequestBody LoginVM loginVM){
        if(userService.existUsername(loginVM.getUsername())) {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginVM.getUsername(), loginVM.getPassword()));
            User user = userRepository.findByUsername(loginVM.getUsername());
            String token = jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
            String current_user = userRepository.fullnameNativeQuery(loginVM.getUsername()) + "****" + userRepository.getByIdNative(loginVM.getUsername());
            Map<Object, Object> map = new HashMap<>();
            map.put("username", user.getUsername());
            map.put("token", token);
            map.put("current_user", current_user);
            return new ApiResponse("user", true, 1, map);
        }
        return new ApiResponse("Bu user mavjud emas", false, 0, loginVM.getUsername());
    }

}
