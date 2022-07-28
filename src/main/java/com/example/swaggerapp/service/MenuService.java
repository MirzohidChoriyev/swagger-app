package com.example.swaggerapp.service;

import com.example.swaggerapp.entity.Menu;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuRepository menuRepository;

    public ApiResponse save(Menu menuDto) {
        Menu menu = new Menu();
        menu.setName(menuDto.getName());
        menu.setComment(menuDto.getComment());
        menu.setIcon_name(menuDto.getIcon_name());
        menu.setPath_name(menuDto.getPath_name());
        menuRepository.save(menu);

        return new ApiResponse("Save Menu", true, menu);
    }

    public ApiResponse getAll() {
        List<Menu> menus = menuRepository.findAllNativeQuery();
        return new ApiResponse("Get All", true, menus);
    }
}
