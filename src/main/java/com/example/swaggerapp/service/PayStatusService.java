package com.example.swaggerapp.service;

import com.example.swaggerapp.entity.PayStatus;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.repository.PayStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayStatusService {
    @Autowired
    PayStatusRepository payStatusRepository;

    public ApiResponse save(PayStatus payStatusDto) {
        PayStatus payStatus = new PayStatus();
        payStatus.setActive(payStatusDto.isActive());
        payStatus.setDescription(payStatusDto.getDescription());
        payStatus.setName(payStatusDto.getName());
        payStatus.setCondition(payStatusDto.getCondition());

        payStatusRepository.save(payStatus);
        return new ApiResponse("Save PayStatus", true, payStatus);
    }
}
