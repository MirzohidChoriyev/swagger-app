package com.example.swaggerapp.service;

import com.example.swaggerapp.entity.Month;
import com.example.swaggerapp.payload.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MonthService {
    @Autowired
    MonthRepository monthRepository;

    public List<Date> dateList;

    public ApiResponse save(){
        List<Month> monthList1 = monthRepository.findAll();
        List<Month> monthList = new ArrayList<>();
        if(monthList1.size() <= 12){
            for (int i = 0; i < 13; i++) {
                Month month = new Month();
                month.setMonth_number(i);
                monthList.add(month);
            }
            monthRepository.saveAll(monthList);
            return new ApiResponse("Ma'lumotlar qo'shildi", true, monthList);
        }
        return new ApiResponse("Qo'shilgan allqachon", false, 0);
    }
}
