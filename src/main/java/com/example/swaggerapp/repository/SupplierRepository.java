package com.example.swaggerapp.repository;

import com.example.swaggerapp.entity.Supplier;
import com.example.swaggerapp.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    @Query(value = "select * from supplier a where a.id = :id", nativeQuery = true)
    Supplier findBySupplierId(Integer id);

}
