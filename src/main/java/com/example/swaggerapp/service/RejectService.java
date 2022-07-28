package com.example.swaggerapp.service;

import com.example.swaggerapp.entity.Reject;
import com.example.swaggerapp.entity.Shop;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.payload.RejectDto;
import com.example.swaggerapp.repository.RejectRepository;
import com.example.swaggerapp.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RejectService {
    @Autowired
    RejectRepository rejectRepository;

    @Autowired
    ShopRepository shopRepository;

    public ApiResponse save(RejectDto rejectDto) {
        Shop shop = shopRepository.findByIdNativeQuery(rejectDto.getShop_id());
        Reject reject = new Reject();
        reject.setDescription(rejectDto.getDescription());
        reject.setApproved(rejectDto.isApproved());
        reject.setShop(shop);
        rejectRepository.save(reject);
        return new ApiResponse("Save Reject", true, reject);
    }

    public Boolean checkShopExists(Integer id){
        Shop shop = shopRepository.findByIdNativeQuery(id);
        if(shop == null){
            return true;
        }
        return false;
    }
}
