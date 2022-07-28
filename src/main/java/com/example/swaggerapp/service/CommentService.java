package com.example.swaggerapp.service;

import com.example.swaggerapp.entity.Comment;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.payload.CommentDto;
import com.example.swaggerapp.repository.CommentRepository;
import com.example.swaggerapp.repository.NewsRepository;
import com.example.swaggerapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    UserRepository userRepository;

    public ApiResponse save(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setComment(commentDto.getComment());
        comment.setNews(newsRepository.findByIdSeenNativeQuery(commentDto.getNews_id()));
        comment.setUser(userRepository.findByIdNativeQuery(commentDto.getUser_id()));
        comment.setSend_date(String.valueOf(new Date()));
        commentRepository.save(comment);

        return new ApiResponse("Save Comment", true, comment);
    }

    public ApiResponse getNewsIdAll(Integer id) {
        List<Comment> comments = commentRepository.findByAllComment(id);
        return new ApiResponse("All comment news id", true, comments);
    }

    public ApiResponse edit(CommentDto commentDto, Integer id) {
        Comment comment = commentRepository.findByCommentId(id);
        comment.setComment(commentDto.getComment());
        commentRepository.save(comment);

        return new ApiResponse("Edited Comment", true);
    }

    public ApiResponse getById(Integer id){
        Comment comment = commentRepository.findByCommentId(id);
        return new ApiResponse("Get By id", true, comment);
    }
}
