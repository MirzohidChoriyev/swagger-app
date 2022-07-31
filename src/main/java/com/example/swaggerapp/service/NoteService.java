package com.example.swaggerapp.service;

import com.example.swaggerapp.entity.Notification;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoteService {
    @Autowired
    NoteRepository noteRepository;

    public ApiResponse getAll() {
        List<Notification> notifications = noteRepository.findAll();
        return new ApiResponse("Note all", true, notifications);
    }

    public ApiResponse save(Notification notificationDto){
        Notification notification = new Notification();
        notification.setComment(notificationDto.getComment());
        notification.setCreate_date(String.valueOf(new Date()));
        notification.setMessage(notificationDto.getMessage());
        notification.setUser_id(notificationDto.getUser_id());
        notification.setType(notificationDto.getType());
        noteRepository.save(notification);

        return new ApiResponse("Save note", true, notification);
    }

    public ApiResponse delete(Integer id) {
        noteRepository.deleteById(id);
        return new ApiResponse("Delete message", true);
    }

    public ApiResponse getById(Integer id) {
        Notification notification = noteRepository.getReferenceById(id);
        return new ApiResponse("Get by id", true, 1, notification);
    }

    public ApiResponse edit(Notification notificationDto, Integer id) {
        Notification notification = noteRepository.getReferenceById(id);
        notification.setComment(notificationDto.getComment());
        notification.setCreate_date(String.valueOf(new Date()));
        notification.setMessage(notificationDto.getMessage());
        notification.setUser_id(notificationDto.getUser_id());
        notification.setType(notificationDto.getType());
        noteRepository.save(notification);

        return new ApiResponse("Save note", true, notification);
    }
}







