package com.example.swaggerapp.repository;

import com.example.swaggerapp.entity.PayStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PayStatusRepository extends JpaRepository<PayStatus, Integer> {
    @Query(value = "select * from pay_status p where p.id =:id", nativeQuery = true)
    PayStatus findByPayStatus(Integer id);
}
