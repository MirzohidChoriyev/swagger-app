package com.example.swaggerapp.controller;

import com.example.swaggerapp.entity.Employee;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/save")
    public ApiResponse save(@RequestBody Employee employeeDto){
        if(employeeService.checkPhone_number(employeeDto.getPhone_number())){
            return new ApiResponse("Ushbu Phone number mavjud: " + employeeDto.getPhone_number(), false);
        }
        return employeeService.save(employeeDto);
    }

    @GetMapping("/all")
    public ApiResponse getAll(){
        return employeeService.getAll();
    }
}