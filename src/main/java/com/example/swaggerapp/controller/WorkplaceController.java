package com.example.swaggerapp.controller;

import com.example.swaggerapp.entity.Workplaces;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.service.WorkplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/workplace")
public class WorkplaceController {
    @Autowired
    WorkplaceService workplaceService;

    @PostMapping("/save")
    public ApiResponse save(@RequestBody Workplaces workplacesDto){
        return workplaceService.save(workplacesDto);
    }
}
