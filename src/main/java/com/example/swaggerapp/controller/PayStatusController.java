package com.example.swaggerapp.controller;

import com.example.swaggerapp.entity.PayStatus;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.service.PayStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/paystatus")
public class PayStatusController {
    @Autowired
    PayStatusService payStatusService;

    @PostMapping("/save")
    public ApiResponse save(@RequestBody PayStatus payStatusDto){
        return payStatusService.save(payStatusDto);
    }
}
