package com.example.swaggerapp.repository;

import com.example.swaggerapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from customer r where r.id = :id", nativeQuery = true)
    Customer findByNativeQuery(Integer id);
}
