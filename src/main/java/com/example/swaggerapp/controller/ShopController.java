package com.example.swaggerapp.controller;

import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.payload.ShopDto;
import com.example.swaggerapp.service.ShopService;
import com.example.swaggerapp.utils.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(Paths.return_path)
@RestController
@RequestMapping("/api/shop")
public class ShopController {
    @Autowired
    ShopService shopService;

    @PostMapping("/save")
    public ApiResponse save(@RequestBody ShopDto shopDto){
        return shopService.save(shopDto);
    }

    @GetMapping("/all")
    public ApiResponse getAll(){
        return shopService.getAll();
    }
}
