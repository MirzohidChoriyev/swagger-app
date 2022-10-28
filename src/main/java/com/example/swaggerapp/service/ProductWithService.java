package com.example.swaggerapp.service;

import com.example.swaggerapp.repository.ProductRepository;
import com.example.swaggerapp.repository.ProductWithRepository;
import com.example.swaggerapp.repository.RejectRepository;
import com.example.swaggerapp.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductWithService {
    @Autowired
    ProductWithRepository productWithRepository;

    @Autowired
    RejectRepository rejectRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SaleRepository saleRepository;
}


