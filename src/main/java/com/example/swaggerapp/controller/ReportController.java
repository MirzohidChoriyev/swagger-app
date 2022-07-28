package com.example.swaggerapp.controller;

import com.example.swaggerapp.entity.Report;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.payload.ReportDto;
import com.example.swaggerapp.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/report")
public class ReportController {
    @Autowired
    ReportService reportService;

    @PostMapping("/save")
    public ApiResponse save(@RequestBody ReportDto reportDto){
        return reportService.save(reportDto);
    }
}
