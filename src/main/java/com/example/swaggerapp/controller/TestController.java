package com.example.swaggerapp.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/get")
    public String test(){
        return "Hello swagger app";
    }

    @PostMapping
    public Object testPost(@RequestBody Object obj){
        return obj;
    }
}
