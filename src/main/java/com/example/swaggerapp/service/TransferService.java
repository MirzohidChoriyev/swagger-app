package com.example.swaggerapp.service;

import com.example.swaggerapp.entity.Transfer;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.payload.TransferDto;
import com.example.swaggerapp.repository.SupplierRepository;
import com.example.swaggerapp.repository.TransferRepository;
import com.example.swaggerapp.repository.UserRepository;
import com.example.swaggerapp.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {
    @Autowired
    TransferRepository transferRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    WarehouseRepository warehouseRepository;

    @Autowired
    SupplierRepository supplierRepository;

    public ApiResponse save(TransferDto transferDto) {
        Transfer transfer = new Transfer();
        transfer.setAgentName(transferDto.getAgentName());
        transfer.setApproved(transferDto.isApproved());
        transfer.setSupplier(supplierRepository.findBySupplierId(transferDto.getSupplier_id()));
        transfer.setToWarehouse(warehouseRepository.findByIdWarehouse(transferDto.getToWarehouse_id()));
        transfer.setFromWarehouse(warehouseRepository.findByIdWarehouse(transferDto.getFromWarehouse_id()));
        transfer.setAgentPhoneNumber(transferDto.getAgentPhoneNumber());

        transferRepository.save(transfer);
        return new ApiResponse("Save Transfer", true, transfer);
    }
}
