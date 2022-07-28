package com.example.swaggerapp.controller;

import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.payload.TransferDto;
import com.example.swaggerapp.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transfer")
public class TransferController {
    @Autowired
    TransferService transferService;

    @PostMapping("/save")
    public ApiResponse save(@RequestBody TransferDto transferDto){
        return transferService.save(transferDto);
    }
}
