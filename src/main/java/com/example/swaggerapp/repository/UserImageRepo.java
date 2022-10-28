package com.example.swaggerapp.repository;
import com.example.swaggerapp.entity.UserImage;
import com.example.swaggerapp.enums.FileStatus;
import com.example.swaggerapp.payload.UserImageNQ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserImageRepo extends JpaRepository<UserImage, Long> {
    UserImage findByHashId(String hashId);

    @Query(value = "select hashid_user_image(:userId)", nativeQuery = true)
    String findByUserIdNativeQuery(Integer userId);

    @Query(value = "update user_image set file_status = 'DRAFT' where user_id =:userId and created_date < (select max(a.created_date) from user_image a where a.user_id =:userId)", nativeQuery = true)
    void update_user_image(Integer userId);

    List<UserImage> findAllByFileStatus(FileStatus fileStatus);

    @Query(value = "select a.*, (select b.fullname from users b where b.id = a.user_id) from user_image a", nativeQuery = true)
    List<UserImage> findAllNQ();
}
