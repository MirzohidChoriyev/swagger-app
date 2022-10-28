package com.example.swaggerapp.service;

import com.example.swaggerapp.entity.Month;
import com.example.swaggerapp.payload.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.util.resources.LocaleData;

import java.time.LocalDate;
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
        int year = LocalDate.now().getYear();
        LocalDate localDate = LocalDate.of(year, 1, 1);

        if(monthList1.size() <= 12){
            while (localDate.getYear() == year){
                java.time.Month month = localDate.getMonth();
                Month month1 = new Month();
                month1.setMonth_number(month.getValue());
                month1.setName(month.name());
                monthList.add(month1);
                localDate = localDate.plusMonths(1);
            }
            monthRepository.saveAll(monthList);
            return new ApiResponse("Ma'lumotlar qo'shildi", true, monthList);
        }
        return new ApiResponse("Qo'shilgan allqachon", false, 0);
    }
}
