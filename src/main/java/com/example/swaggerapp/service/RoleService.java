package com.example.swaggerapp.service;

import com.example.swaggerapp.entity.Role;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public ApiResponse saveRole(Role roleDto){
        int len_role = roleRepository.findAll().size();
        Role role = new Role();
        role.setName(roleDto.getName());
        role.setRole_id(len_role + 1);
        role.setRole_category("role_category");
        roleRepository.save(role);
        return new ApiResponse("Save role", true, role);
    }

    public Boolean checkExistsRole(String role_name){
        return roleRepository.existsByName(role_name);
    }
}


