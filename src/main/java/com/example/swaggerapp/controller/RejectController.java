package com.example.swaggerapp.controller;

import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.payload.RejectDto;
import com.example.swaggerapp.service.RejectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reject")
public class RejectController {
    @Autowired
    RejectService rejectService;

    @PostMapping("/save")
    public ApiResponse save(@RequestBody RejectDto rejectDto){
        if(rejectService.checkShopExists(rejectDto.getShop_id())){
            return new ApiResponse("Ushbu Id lik shop mavjud emas", false, rejectDto.getShop_id());
        }
        return rejectService.save(rejectDto);
    }
}
