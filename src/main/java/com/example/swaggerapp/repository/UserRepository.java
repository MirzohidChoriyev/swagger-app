package com.example.swaggerapp.repository;

import com.example.swaggerapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUsername(String username);

    User findByUsername(String username);

    @Query(value = "select * from users u where u.username = :username", nativeQuery = true)
    User findByUsernameQuery(String username);

    @Query(value = "select * from users u where u.id = :id", nativeQuery = true)
    User findByIdNativeQuery(Integer id);
}
