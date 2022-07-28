package com.example.swaggerapp.service;

import com.example.swaggerapp.entity.Warehouse;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.payload.WarehouseDto;
import com.example.swaggerapp.repository.ShopRepository;
import com.example.swaggerapp.repository.UserRepository;
import com.example.swaggerapp.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShopRepository shopRepository;

    public ApiResponse save(WarehouseDto warehouseDto) {
        Warehouse warehouse = new Warehouse();
        warehouse.setActive(warehouseDto.isActive());
        warehouse.setAddress(warehouseDto.getAddress());
        warehouse.setDescription(warehouseDto.getDescription());
        warehouse.setName(warehouseDto.getName());
        warehouse.setShop(shopRepository.findByIdNativeQuery(warehouseDto.getShop_id()));
        warehouse.setWarehouse_keeper(userRepository.findByIdNativeQuery(warehouseDto.getUser_id()));

        warehouseRepository.save(warehouse);
        return new ApiResponse("Save warehouse", true, warehouse);
    }
}
