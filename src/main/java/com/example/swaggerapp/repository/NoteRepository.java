package com.example.swaggerapp.repository;


import com.example.swaggerapp.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Notification, Integer> {

}
