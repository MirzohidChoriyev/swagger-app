package com.example.swaggerapp.repository;
import com.example.swaggerapp.entity.UserImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserImageRepo extends JpaRepository<UserImage, Long> {
    UserImage findByHashId(String hashId);

    @Query(value = "select hashid_user_image(:userId)", nativeQuery = true)
    String findByUserIdNativeQuery(Integer userId);

    @Query(value = "delete from user_image a where a.user_id =:userId and a.created_date < ( select max(b.created_date) from user_image b where b.user_id =:userId );", nativeQuery = true)
    void delete_user_image(Integer userId);
}
