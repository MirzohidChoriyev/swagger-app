package com.example.swaggerapp.controller;

import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.payload.CommentDto;
import com.example.swaggerapp.service.CommentService;
import com.example.swaggerapp.utils.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@CrossOrigin(Paths.return_path)
@RestController
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/save")
    public ApiResponse save(@RequestBody CommentDto commentDto){
        return commentService.save(commentDto);
    }

    @GetMapping("/newsIdAll/{id}")
    public ApiResponse getAllNewsId(@PathVariable Integer id){
        return commentService.getNewsIdAll(id);
    }

    @PutMapping("/edit/{id}")
    public ApiResponse edit(@RequestBody CommentDto commentDto, @PathVariable Integer id){
        return commentService.edit(commentDto, id);
    }

    @GetMapping("/getById/{id}")
    public ApiResponse getById(@PathVariable Integer id){
        return commentService.getById(id);
    }
}
