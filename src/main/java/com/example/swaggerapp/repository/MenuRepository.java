package com.example.swaggerapp.repository;

import com.example.swaggerapp.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    @Query(value = "select * from menu order by id", nativeQuery = true)
    List<Menu> findAllNativeQuery();

}
