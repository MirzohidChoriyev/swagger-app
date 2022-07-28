package com.example.swaggerapp.service;

import com.example.swaggerapp.entity.Shop;
import com.example.swaggerapp.entity.User;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.payload.ShopDto;
import com.example.swaggerapp.repository.ShopRepository;
import com.example.swaggerapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
    @Autowired
    ShopRepository shopRepository;

    @Autowired
    UserRepository userRepository;

    public ApiResponse save(ShopDto shopDto) {
        User seller_user = userRepository.findByIdNativeQuery(shopDto.getSeller_id());
        Shop shop = new Shop();

        shop.setActive(shopDto.isActive());
        shop.setName(shopDto.getName());
        shop.setAddress(shopDto.getAddress());
        shop.setDescription(shopDto.getDescription());
        shop.setSeller(seller_user);
        shopRepository.save(shop);
        return new ApiResponse("Shop user save", true, shop);
    }
}
