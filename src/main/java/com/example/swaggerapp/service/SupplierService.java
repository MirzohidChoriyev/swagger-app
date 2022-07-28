package com.example.swaggerapp.service;

import com.example.swaggerapp.entity.Supplier;
import com.example.swaggerapp.entity.User;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.repository.SupplierRepository;
import com.example.swaggerapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    UserRepository userRepository;

    public ApiResponse save(Supplier supplierDto) {
        User supplier_user = userRepository.findByUsernameQuery(supplierDto.getSupplier_username());
        Supplier supplier = new Supplier();
        supplier.setAddress(supplierDto.getAddress());
        supplier.setLat(supplierDto.getLat());
        supplier.setLon(supplierDto.getLon());
        supplier.setName(supplier_user.getFullname());
        supplier.setPhoneNumber(supplierDto.getPhoneNumber());
        supplier.setSupplier_username("....");
        supplier.setSuppliers(supplier_user);
        supplierRepository.save(supplier);
        return new ApiResponse("Save Supplier", true, supplier);
    }
}
