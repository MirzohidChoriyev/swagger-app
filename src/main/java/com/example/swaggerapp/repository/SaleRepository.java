package com.example.swaggerapp.repository;

import com.example.swaggerapp.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {

    @Query(value = "select * from sale s where s.id = :id", nativeQuery = true)
    Sale saleFindBySale(Integer id);
}
