package com.example.swaggerapp.repository;

import com.example.swaggerapp.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
    @Query(value = "select * from news n where n.id =:id", nativeQuery = true)
    News findByIdSeenNativeQuery(Integer id);

    @Query(value = "select * from news a order by a.id desc", nativeQuery = true)
    List<News> findAllNativeQuery();

    @Query(value = "select b.*, a.fullname from users a, news b where a.id = b.sender_id", nativeQuery = true)
    List<News> findByUsersNewsJoin();

    @Query(value = "select * from news a where a.id = :id", nativeQuery = true)
    News getByIdNews(Integer id);

    @Query(value = "delete from news a where a.id = :id", nativeQuery = true)
    void newsDeleteById(Integer id);
}
