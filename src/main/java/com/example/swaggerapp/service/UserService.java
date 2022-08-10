package com.example.swaggerapp.service;

import com.example.swaggerapp.entity.User;
import com.example.swaggerapp.enums.UserStatus;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ApiResponse save(User userDto){
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setFullname(userDto.getFullname());
        user.setStatus(UserStatus.valueOf("ACTIVE"));
        user.setRoles(userDto.getRoles());
        user.setShop_id(userDto.getShop_id());
        userRepository.save(user);
        return new ApiResponse("Save user", true, user);
    }

    public Boolean checkExistUsername(String username){
        return userRepository.existsByUsername(username);
    }

    public ApiResponse edit(User userDto, Integer id) {
        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()){
            return new ApiResponse("Ushbu id: " + id + " foydalanuvchi mavjud emas", false);
        }
        user.get().setUsername(userDto.getUsername());
        user.get().setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.get().setFullname(userDto.getFullname());
        user.get().setRoles(userDto.getRoles());

        user.get().setStatus(UserStatus.valueOf("ACTIVE"));
        userRepository.save(user.get());
        return new ApiResponse("Edit user", true, user);
    }

    public ApiResponse delete(Integer id) {
        Optional<User> userId = userRepository.findById(id);
        if(!userId.isPresent()){
            return new ApiResponse("Ushbu id: " + id + " foydalanuvchi mavjud emas", false);
        }
        userRepository.delete(userId.get());
        return new ApiResponse("Delete user", true, userId.get());
    }

    public ApiResponse getById(Integer id) {
        Optional<User> userId = userRepository.findById(id);
        if(!userId.isPresent()){
            return new ApiResponse("Ushbu id: " + id + " foydalanuvchi mavjud emas", false);
        }
        return new ApiResponse("User id: " + id + " li", true, userId.get());
    }

    public ApiResponse getByUsername(String username) {
        User user = userRepository.findByUsernameQuery(username);
        if(user == null){
            return new ApiResponse("Ushbu id: " + username + " li foydalanuvchi mavjud emas", false);
        }
        return new ApiResponse("User id: " + username, true, user);
    }

    public boolean existUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public ApiResponse getByUser(Integer id) {
        User user = userRepository.findByIdNativeQuery(id);
        return new ApiResponse("Current user", true, user);
    }

    public ApiResponse loginEdit(User userDto, Integer id) {
        User user = userRepository.findByIdNativeQuery(id);
        user.setUsername(userDto.getUsername());
        userRepository.save(user);
        return new ApiResponse("Edit user", true, user);
    }

    public Integer users_count(){
        return userRepository.all_users_count();
    }

    public ApiResponse getByUsers() {
        List<User> users = userRepository.findAll();
        return new ApiResponse("Get users", true, users);
    }
}
