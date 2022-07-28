package com.example.swaggerapp.repository;

import com.example.swaggerapp.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransferRepository extends JpaRepository<Transfer, Integer> {

    @Query(value = "select * from transfer a where a.id = :id", nativeQuery = true)
    Transfer findByTransferId(Integer id);

}
