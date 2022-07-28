package com.example.swaggerapp.controller;

import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.payload.CategoryDto;
import com.example.swaggerapp.security.SecurityUtils;
import com.example.swaggerapp.service.CategoryService;
import com.example.swaggerapp.utils.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(Paths.return_path)
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/save")
    public ApiResponse save(@RequestBody CategoryDto categoryDto){
        return categoryService.save(categoryDto);
    }

    @GetMapping("/all")
    public ApiResponse getAll(){
        String username = SecurityUtils.getCurrentUsername().get();
        return categoryService.getAll();
    }
}
