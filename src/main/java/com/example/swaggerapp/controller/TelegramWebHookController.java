package com.example.swaggerapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/webhook")
public class TelegramWebHookController {

    @PostMapping
    public void webhook(@RequestBody Object object){
        System.out.println(object);
    }
}
