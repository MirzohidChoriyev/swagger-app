package com.example.swaggerapp.repository;

import com.example.swaggerapp.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Integer> {
    @Query(value = "select * from salaries a where a.user_id=:user_id", nativeQuery = true)
    List<Salary> getBySalaryUserId(Integer user_id);
}
