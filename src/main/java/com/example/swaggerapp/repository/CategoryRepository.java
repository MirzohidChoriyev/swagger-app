package com.example.swaggerapp.repository;

import com.example.swaggerapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value = "select * from category c where c.id = :id", nativeQuery = true)
    Category findByCategory(Integer id);
}
