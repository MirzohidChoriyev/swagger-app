package com.example.swaggerapp.controller;

import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.payload.SaleDto;
import com.example.swaggerapp.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sale")
public class SaleController {
    @Autowired
    SaleService saleService;

    @PostMapping("/save")
    public ApiResponse save(@RequestBody SaleDto saleDto){
        return saleService.save(saleDto);
    }
}
