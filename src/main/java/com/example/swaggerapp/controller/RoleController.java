package com.example.swaggerapp.controller;

import com.example.swaggerapp.entity.Role;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.service.RoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/save")
    public ApiResponse saveRole(@RequestBody Role roleDto){
        if(roleService.checkExistsRole(roleDto.getName())){
            return new ApiResponse("Ushbu role mavjud", false, roleDto.getName());
        }
        return roleService.saveRole(roleDto);
    }
}
