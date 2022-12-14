package com.example.swaggerapp.repository;

import com.example.swaggerapp.entity.Bonus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonusRepository extends JpaRepository<Bonus, Integer> {
    
}
