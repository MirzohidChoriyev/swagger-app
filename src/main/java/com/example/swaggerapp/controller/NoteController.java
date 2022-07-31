package com.example.swaggerapp.controller;

import com.example.swaggerapp.entity.Notification;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.service.NoteService;
import com.example.swaggerapp.utils.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(Paths.return_path)
@RestController
@RequestMapping("/api/notification")
public class NoteController {
    @Autowired
    NoteService noteService;

    @GetMapping("/getAll")
    public ApiResponse getAll(){
        return noteService.getAll();
    }

    @PostMapping("/save")
    public ApiResponse save(@RequestBody Notification notification){
        return noteService.save(notification);
    }

    @PutMapping("/edit/{id}")
    public ApiResponse edit(@RequestBody Notification notificationDto, @PathVariable Integer id){
        return noteService.edit(notificationDto, id);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable Integer id){
        return noteService.delete(id);
    }

    @GetMapping("/getById/{id}")
    public ApiResponse getById(@PathVariable Integer id){
        return noteService.getById(id);
    }
}
