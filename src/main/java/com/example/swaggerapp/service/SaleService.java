package com.example.swaggerapp.service;

import com.example.swaggerapp.entity.*;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.payload.SaleDto;
import com.example.swaggerapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {
    @Autowired
    SaleRepository saleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PaytypeRepository paytypeRepository;

    @Autowired
    PayStatusRepository payStatusRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ReportRepository reportRepository;

    @Autowired
    ShopRepository shopRepository;

    public ApiResponse save(SaleDto saleDto) {
        Sale sale = new Sale();

        Customer customer = customerRepository.findByNativeQuery(saleDto.getCustomer_id());
        Shop shop = shopRepository.findByIdNativeQuery(saleDto.getShop_id());
        Report report = reportRepository.findByReportNativeQuery(saleDto.getReport_id());
        User user = userRepository.findByIdNativeQuery(saleDto.getSeller_id());
        PayType payType = paytypeRepository.findByPaytype(saleDto.getPayType_id());
        PayStatus payStatus = payStatusRepository.findByPayStatus(saleDto.getPayStatus_id());

        sale.setCustomer(customer);
        sale.setPayStatus(payStatus);
        sale.setPayType(payType);
        sale.setReport(report);
        sale.setSeller(user);
        sale.setShop(shop);

        saleRepository.save(sale);
        return new ApiResponse("Save Sale", true, sale);
    }
}
