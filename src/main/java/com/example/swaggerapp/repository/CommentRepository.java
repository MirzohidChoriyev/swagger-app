package com.example.swaggerapp.repository;

import com.example.swaggerapp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query(value = "select * from comment a where a.id = :id", nativeQuery = true)
    Comment findByCommentId(Integer id);

    @Query(value = "select * from comment c where c.news_id = :id order by c.id", nativeQuery = true)
    List<Comment> findByAllComment(Integer id);

}

