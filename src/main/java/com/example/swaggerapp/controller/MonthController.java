package com.example.swaggerapp.controller;

import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.service.MonthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/month")
public class MonthController {
    @Autowired
    MonthService monthService;

    @GetMapping("/add")
    public ApiResponse save(){
        return monthService.save();
    }
}
