package com.example.swaggerapp.repository;

import com.example.swaggerapp.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {

    @Query(value = "select * from warehouse w where w.id = :id", nativeQuery = true)
    Warehouse findByIdWarehouse(Integer id);

}

