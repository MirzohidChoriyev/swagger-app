package com.example.swaggerapp.repository;

import com.example.swaggerapp.entity.Reject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RejectRepository extends JpaRepository<Reject, Integer> {

    @Query(value = "select * from reject a where a.id = :id", nativeQuery = true)
    Reject findByRejectId(Integer id);

}
