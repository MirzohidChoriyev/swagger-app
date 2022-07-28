package com.example.swaggerapp.controller;

import com.example.swaggerapp.entity.News;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.payload.NewsDto;
import com.example.swaggerapp.service.NewsService;
import com.example.swaggerapp.utils.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(Paths.return_path)
@RestController
@RequestMapping("/api/news")
public class NewsController {
    @Autowired
    NewsService newsService;

    @PostMapping("/save")
    public ApiResponse save(@RequestBody NewsDto newsDto){
        return newsService.save(newsDto);
    }

    @GetMapping("/all")
    public ApiResponse getAll(){
        return newsService.getAll();
    }

    @PutMapping("/edit_seen/{id}")
    public ApiResponse edit_seing(@RequestBody NewsDto newsDto, @PathVariable Integer id){
        return newsService.edit_seing(newsDto, id);
    }

    @GetMapping("/getById/{id}")
    public ApiResponse getById(@PathVariable Integer id){
        return newsService.getById(id);
    }

    @PutMapping("/edit/{id}")
    public ApiResponse edit(@RequestBody NewsDto newsDto, @PathVariable Integer id){
        return newsService.edit(newsDto, id);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable Integer id){
        return newsService.delete(id);
    }
}
