package com.example.swaggerapp.service;

import com.example.swaggerapp.entity.Report;
import com.example.swaggerapp.entity.Shop;
import com.example.swaggerapp.entity.User;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.payload.ReportDto;
import com.example.swaggerapp.repository.ReportRepository;
import com.example.swaggerapp.repository.ShopRepository;
import com.example.swaggerapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    @Autowired
    ReportRepository reportRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShopRepository shopRepository;

    public ApiResponse save(ReportDto reportDto) {
        User user = userRepository.findByIdNativeQuery(reportDto.getUser_id());
        Shop shop = shopRepository.findById(reportDto.getShop_id()).get();
        Report report = new Report();
        report.setApproved(reportDto.isApproved());
        report.setShop(shop);
        report.setApprover(user);
        reportRepository.save(report);
        return new ApiResponse("Save Report", true, report);
    }
}
