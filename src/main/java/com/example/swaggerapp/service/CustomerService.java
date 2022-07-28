package com.example.swaggerapp.service;

import com.example.swaggerapp.entity.Customer;
import com.example.swaggerapp.entity.PayType;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.payload.CustomerDto;
import com.example.swaggerapp.repository.CustomerRepository;
import com.example.swaggerapp.repository.PaytypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PaytypeRepository paytypeRepository;

    public ApiResponse save(CustomerDto customerDto) {
        PayType payType = paytypeRepository.findByPaytype(customerDto.getPay_id());
        Customer customer = new Customer();
        customer.setSumma(customerDto.getSumma());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setActive(customerDto.isActive());
        customer.setDescription(customerDto.getDescription());
        customer.setName(customerDto.getName());
        customer.setPayType(payType);
        customerRepository.save(customer);
        return new ApiResponse("Save Customer", true, customer);
    }
}
