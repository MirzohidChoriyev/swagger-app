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

    @Query(value = "select u.fullname from users u where u.username = :username", nativeQuery = true)
    String fullnameNativeQuery(String username);

    @Query(value = "select u.id from users u where u.username = :username", nativeQuery = true)
    String getByIdNative(String username);

    @Query(value = "select all_users_count()", nativeQuery = true)
    Integer all_users_count();

    @Query(value = "select user_move_clients()", nativeQuery = true)
    Integer userMoveClients();
}
