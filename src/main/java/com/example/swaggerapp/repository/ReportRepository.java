package com.example.swaggerapp.repository;

import com.example.swaggerapp.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {
    @Query(value = "select * from report r where r.id = :id", nativeQuery = true)
    Report findByReportNativeQuery(Integer id);
}
