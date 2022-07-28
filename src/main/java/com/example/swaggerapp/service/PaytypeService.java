package com.example.swaggerapp.service;

import com.example.swaggerapp.entity.PayType;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.repository.PaytypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaytypeService {
    @Autowired
    PaytypeRepository paytypeRepository;

    public ApiResponse save(PayType payType) {
        PayType payType1 = new PayType();
        payType1.setName(payType.getName());
        payType1.setDescription(payType.getDescription());
        payType1.setActive(payType.isActive());
        paytypeRepository.save(payType1);
        return new ApiResponse("Save PayType", true, payType1);
    }
}
