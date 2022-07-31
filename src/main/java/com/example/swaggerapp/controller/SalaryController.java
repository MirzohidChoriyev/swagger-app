package com.example.swaggerapp.controller;

import com.example.swaggerapp.entity.Salary;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.service.SalaryService;
import com.example.swaggerapp.utils.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(Paths.return_path)
@RestController
@RequestMapping("/api/salaries")
public class SalaryController {
    @Autowired
    SalaryService salaryService;

    @PostMapping("/save")
    public ApiResponse save(@RequestBody Salary salaryDto){
        return salaryService.save(salaryDto);
    }

    @GetMapping("/getsalary/{user_id}")
    public ApiResponse getSalary(@PathVariable Integer user_id){
        return salaryService.getSalary(user_id);
    }
}
