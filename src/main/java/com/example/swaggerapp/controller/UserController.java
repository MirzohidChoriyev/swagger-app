package com.example.swaggerapp.controller;

import com.example.swaggerapp.entity.User;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ApiResponse create(@RequestBody User userDto){
        if (userService.checkExistUsername(userDto.getUsername())){
            return new ApiResponse("Bu foydalanuvchi mavjud", false, userDto.getUsername());
        } else
        if(!checkPasswordLength(userDto.getPassword())){
            return new ApiResponse("Parol uzunligi 4 tadan kam bo'lmasligi kerak", false, userDto.getPassword());
        }
        return userService.save(userDto);
    }

    public boolean checkPasswordLength(String password){
        return password.length() >= 4;
    }

    @PutMapping("/edit/{id}")
    public ApiResponse edit(@RequestBody User userDto, @PathVariable Integer id){
        if (userService.checkExistUsername(userDto.getUsername())){
            return new ApiResponse("Bu foydalanuvchi mavjud", false, userDto.getUsername());
        } else
        if(!checkPasswordLength(userDto.getPassword())){
            return new ApiResponse("Parol uzunligi 4 tadan kam bo'lmasligi kerak", false, userDto.getPassword());
        }
        return userService.edit(userDto, id);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable Integer id){
        return userService.delete(id);
    }

    @GetMapping("/getById/{id}")
    public ApiResponse getById(@PathVariable Integer id){
        //String username = SecurityUtils.getCurrentUsername().get();
        return userService.getById(id);
    }

    @GetMapping("/getByUsername/{username}")
    public ApiResponse getByUsername(@PathVariable String username){
        return userService.getByUsername(username);
    }
}

