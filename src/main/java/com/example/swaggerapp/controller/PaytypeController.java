package com.example.swaggerapp.controller;

import com.example.swaggerapp.entity.PayType;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.service.PaytypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/paytype")
public class PaytypeController {
    @Autowired
    PaytypeService paytypeServive;

    @PostMapping("/save")
    public ApiResponse save(@RequestBody PayType payType){
        return paytypeServive.save(payType);
    }
}
