package com.example.swaggerapp.service;

import com.example.swaggerapp.entity.News;
import com.example.swaggerapp.entity.User;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.payload.NewsDto;
import com.example.swaggerapp.repository.NewsRepository;
import com.example.swaggerapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NewsService {
    @Autowired
    NewsRepository newsRepository;

    @Autowired
    UserRepository userRepository;

    public ApiResponse save(NewsDto newsDto) {
        User sender = userRepository.findByIdNativeQuery(newsDto.getSender_id());

        News news = new News();
        news.setMessage(newsDto.getMessage());
        news.setComment(newsDto.getDescription());
        news.setActive(true);
        news.setCreated_date(String.valueOf(new Date()));
        news.setSeen(false);
        news.setSender(userRepository.findByIdNativeQuery(newsDto.getSender_id()));

        newsRepository.save(news);
        return new ApiResponse("Save News", true, news);
    }

    public ApiResponse getAll() {
        List<News> news = newsRepository.findAllNativeQuery();
        return new ApiResponse("Get All", true, news);
    }

    public ApiResponse edit_seing(NewsDto newsDto, Integer id) {
        News news = newsRepository.findByIdSeenNativeQuery(id);
        news.setSeen(newsDto.isSeen());
        newsRepository.save(news);

        return new ApiResponse("Edit seen id:" + id, true);
    }

    public ApiResponse getById(Integer id) {
        News news = newsRepository.getByIdNews(id);
        return new ApiResponse("Get By Id", true, news);
    }

    public ApiResponse edit(NewsDto newsDto, Integer id) {
        News news = newsRepository.getByIdNews(id);
        news.setCreated_date(String.valueOf(new Date()));
        news.setComment(newsDto.getDescription());
        news.setMessage(newsDto.getMessage());
        newsRepository.save(news);

        return new ApiResponse("Edit news", true, news);
    }

    public ApiResponse delete(Integer id) {
        newsRepository.deleteById(id);
        return new ApiResponse("Delete news", true);
    }
}


