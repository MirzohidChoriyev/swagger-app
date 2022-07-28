package com.example.swaggerapp.repository;

import com.example.swaggerapp.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {
    @Query(value = "select * from shop e where e.id = :id", nativeQuery = true)
    Shop findByIdNativeQuery(Integer id);
}
