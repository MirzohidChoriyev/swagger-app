package com.example.swaggerapp.controller;

import com.example.swaggerapp.entity.Menu;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.service.MenuService;
import com.example.swaggerapp.utils.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(Paths.return_path)
@RestController
@RequestMapping("/api/menu")
public class MenuController {
    @Autowired
    MenuService menuService;

    @PostMapping("/save")
    public ApiResponse save(@RequestBody Menu menuDto){
        return menuService.save(menuDto);
    }

    @GetMapping("/all")
    public ApiResponse getAll(){
        return menuService.getAll();
    }
}


