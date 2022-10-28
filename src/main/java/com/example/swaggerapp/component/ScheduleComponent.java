package com.example.swaggerapp.component;

import com.example.swaggerapp.repository.ProductWithRepository;
import com.example.swaggerapp.service.UserImageService;
import com.example.swaggerapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleComponent {

    final
    UserImageService userImageService;

    final
    UserService userService;

    final
    ProductWithRepository productWithRepository;

    public ScheduleComponent(UserImageService userImageService, UserService userService, ProductWithRepository productWithRepository) {
        this.userImageService = userImageService;
        this.userService = userService;
        this.productWithRepository = productWithRepository;
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void deleteUserImageDraft(){
        userImageService.deleteByStatusDraft();
    }

    @Scheduled(cron = "0 0 0 * * *")
    public Integer products_move(){
        return productWithRepository.products_move();
    }

    @Scheduled(cron = "0 0 0 * * *")
    public Integer userMoveClients(){
        return userService.user_move_clients();
    }
}
