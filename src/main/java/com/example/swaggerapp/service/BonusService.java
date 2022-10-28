package com.example.swaggerapp.service;

import com.example.swaggerapp.entity.Bonus;
import com.example.swaggerapp.entity.User;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.payload.BonusDto;
import com.example.swaggerapp.repository.BonusRepository;
import com.example.swaggerapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BonusService {
    @Autowired
    BonusRepository bonusRepository;

    @Autowired
    UserRepository userRepository;

    public ApiResponse save(BonusDto bonusDto) {
        User user = userRepository.findByIdNativeQuery(bonusDto.getUser_id());
        Bonus bonus = new Bonus();
        bonus.setBonusSum(bonusDto.getBonusSum());
        bonus.setDescription(bonusDto.getDescription());
        bonus.setUser_id(bonusDto.getUser_id());
        bonus.setPercent(bonusDto.getPercent());
        bonus.setCondition(bonusDto.getCondition());
        bonusRepository.save(bonus);
        return new ApiResponse("Save Bonus", true, bonus);
    }

    public Boolean checkUserExists(Integer id){
        User user = userRepository.findByIdNativeQuery(id);
        if(user == null){
            return true;
        }
        return false;
    }
}
