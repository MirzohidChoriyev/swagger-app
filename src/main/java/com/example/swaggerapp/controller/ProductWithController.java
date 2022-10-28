package com.example.swaggerapp.controller;

import com.example.swaggerapp.service.ProductWithService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/productwithamount")
public class ProductWithController {
    @Autowired
    ProductWithService productWithService;
}
