package com.example.swaggerapp.controller;

import com.example.swaggerapp.entity.Supplier;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @PostMapping("/save")
    public ApiResponse save(@RequestBody Supplier supplierDto){
        return supplierService.save(supplierDto);
    }
}
