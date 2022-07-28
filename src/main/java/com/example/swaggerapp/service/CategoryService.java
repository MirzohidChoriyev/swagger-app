package com.example.swaggerapp.service;

import com.example.swaggerapp.entity.Category;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.payload.CategoryDto;
import com.example.swaggerapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public ApiResponse save(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setActive(categoryDto.isActive());
        categoryRepository.save(category);
        return new ApiResponse("Save Category", true, category);
    }

    public ApiResponse getAll() {
        List<Category> categories = categoryRepository.findAll();
        return new ApiResponse("Get All", true, categories);
    }
}
