package com.example.swaggerapp.controller;

import com.example.swaggerapp.entity.Card;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/api/card")
public class CardController {
    @Autowired
    CardService cardService;

    @PostMapping("/save")
    public ApiResponse save(@RequestBody Card cardDto) throws ParseException {
        return cardService.save(cardDto);
    }

    @GetMapping("/getByCard/{userId}")
    private ApiResponse getByCardUserId(@PathVariable Integer userId){
        return cardService.getByCardUserId(userId);
    }
}
