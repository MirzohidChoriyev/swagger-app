package com.example.swaggerapp.service;

import com.example.swaggerapp.entity.ProductWithAmount;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.payload.ProductWithDto;
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

    public ApiResponse save(ProductWithDto productWithDto) {
        ProductWithAmount product = new ProductWithAmount();
        product.setAmount(productWithDto.getAmount());
        product.setReject(rejectRepository.findByRejectId(productWithDto.getReject_id()));
        product.setPrice(productWithDto.getPrice());
        product.setSale(saleRepository.saleFindBySale(productWithDto.getSale_id()));

        productWithRepository.save(product);
        return new ApiResponse("Save Product", true, product);
    }
}


