package com.example.swaggerapp.repository;

import com.example.swaggerapp.entity.PayType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaytypeRepository extends JpaRepository<PayType, Integer> {
    @Query(value = "select * from pay_type p where p.id = :id", nativeQuery = true)
    PayType findByPaytype(Integer id);
}

