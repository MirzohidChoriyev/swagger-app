package com.example.swaggerapp.repository;

import com.example.swaggerapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select * from product a where a.id = :id", nativeQuery = true)
    Product findByIdProduct(Integer id);

    @Query(value = "select * from product a order by a.id asc", nativeQuery = true)
    List<Product> getAllByProducts();

    @Query(value = "update product p set substring(p.count_note, -1) = 'P' where p.id = :id", nativeQuery = true)
    void updateNote(Integer id);

    @Query(value = "select * from product a where a.count_active = 'P' order by a.id asc", nativeQuery = true)
    List<Product> getNeedAllByProducts();

    @Query(value = "select all_products_count()", nativeQuery = true)
    Integer all_products_count();
}
