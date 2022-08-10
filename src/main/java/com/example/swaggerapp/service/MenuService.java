package com.example.swaggerapp.service;

import com.example.swaggerapp.entity.Menu;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuRepository menuRepository;

    public ApiResponse save(List<Menu> menuDto) {
        menuRepository.saveAll(menuDto);
        return new ApiResponse("Save Menu", true, menuDto);
    }

    public ApiResponse getAll() {
        List<Menu> menus = menuRepository.findAllNativeQuery();
        return new ApiResponse("Get All", true, menus);
    }
}
