package com.example.swaggerapp.repository;

import com.example.swaggerapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    boolean existsByName(String name);
}
