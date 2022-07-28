package com.example.swaggerapp.repository;

import com.example.swaggerapp.entity.Workplaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkplaceRepository extends JpaRepository<Workplaces, Integer> {

}
