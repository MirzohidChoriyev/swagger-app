package com.example.swaggerapp.controller;

import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.payload.BonusDto;
import com.example.swaggerapp.service.BonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bonus")
public class BonusController {
    @Autowired
    BonusService bonusService;

    @PostMapping("/save")
    public ApiResponse save(BonusDto bonusDto){
        if(bonusService.checkUserExists(bonusDto.getUser_id())){
            return new ApiResponse("Ushbu id lik user mavjud emas", false, bonusDto.getUser_id());
        }
        return bonusService.save(bonusDto);
    }
}
