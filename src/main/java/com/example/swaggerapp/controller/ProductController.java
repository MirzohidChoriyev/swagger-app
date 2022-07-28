package com.example.swaggerapp.controller;

import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.payload.ProductDto;
import com.example.swaggerapp.service.ProductService;
import com.example.swaggerapp.utils.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(Paths.return_path)
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/save")
    public ApiResponse save(@RequestBody ProductDto productDto){
        return productService.save(productDto);
    }

    @PutMapping("/edit/{id}")
    public ApiResponse edit(@RequestBody ProductDto productDto, @PathVariable Integer id){
        return productService.edit(productDto, id);
    }

    @GetMapping("/all")
    public ApiResponse getAll(){
        return productService.getAll();
    }

    @GetMapping("/needall")
    public ApiResponse getNeedAll(){
        return productService.getNeedAll();
    }

    @GetMapping("/getById/{id}")
    public ApiResponse getById(@PathVariable Integer id){
        return productService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable Integer id){
        return productService.delete(id);
    }

    @GetMapping("/updateNoteChar")
    public void updateNoteChar(){
        productService.updateNoteChar();
    }
}
