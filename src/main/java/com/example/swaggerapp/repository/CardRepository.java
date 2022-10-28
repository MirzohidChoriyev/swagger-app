package com.example.swaggerapp.repository;

import com.example.swaggerapp.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
    @Query(value = "select * from cards a where a.user_id =:userId", nativeQuery = true)
    Card findByCardUserIdNQ(Integer userId);
}
