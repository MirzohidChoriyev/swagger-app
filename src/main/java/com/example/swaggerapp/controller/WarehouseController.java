package com.example.swaggerapp.controller;

import com.example.swaggerapp.entity.Warehouse;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.payload.WarehouseDto;
import com.example.swaggerapp.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/warehouse")
public class WarehouseController {
    @Autowired
    WarehouseService warehouseService;

    @PostMapping("/save")
    public ApiResponse save(@RequestBody WarehouseDto warehouseDto){
        return warehouseService.save(warehouseDto);
    }
}
