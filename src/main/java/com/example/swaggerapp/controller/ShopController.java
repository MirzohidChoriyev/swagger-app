package com.example.swaggerapp.controller;

import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.payload.ShopDto;
import com.example.swaggerapp.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shop")
public class ShopController {
    @Autowired
    ShopService shopService;

    @PostMapping("/save")
    public ApiResponse save(@RequestBody ShopDto shopDto){
        return shopService.save(shopDto);
    }
}
