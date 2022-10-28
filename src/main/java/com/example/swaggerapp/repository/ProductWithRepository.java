package com.example.swaggerapp.repository;

import com.example.swaggerapp.entity.ProductWithAmount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductWithRepository extends JpaRepository<ProductWithAmount, Integer> {

    @Query(value = "select * from product_with_amount a where a.id = :id", nativeQuery = true)
    ProductWithAmount findByProductWithId(Integer id);

    @Query(value = "select products_move_products();", nativeQuery = true)
    Integer products_move();
}
