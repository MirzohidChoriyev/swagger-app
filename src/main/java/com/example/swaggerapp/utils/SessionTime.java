package com.example.swaggerapp.utils;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(Paths.return_path)
@RestController
@RequestMapping("/api/utils")
public class SessionTime {

    @GetMapping("/session_time")
    public Integer session(){
        return Paths.session_time;
    }

}
