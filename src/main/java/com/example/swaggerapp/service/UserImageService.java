package com.example.swaggerapp.service;

import com.example.swaggerapp.entity.UserImage;
import com.example.swaggerapp.enums.FileStatus;
import com.example.swaggerapp.repository.UserImageRepo;
import org.hashids.Hashids;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@Service
public class UserImageService {
    @Autowired
    UserImageRepo userImageRepo;

    @Value("${upload.user_image_file.path}")
    private String uploadPathFolder;

    private final Hashids hashidsName;
    private final Hashids hashids;

    public UserImageService() {
        this.hashids = new Hashids(getClass().getName(), 12);
        this.hashidsName = new Hashids(getClass().getName(), 10);
    }

    public ResponseEntity save(MultipartFile multipartFile, Integer userId){
        UserImage userImage = new UserImage();
        userImage.setName(multipartFile.getOriginalFilename());
        userImage.setFileSize(multipartFile.getSize());
        userImage.setContentType(multipartFile.getContentType());
        userImage.setFileStatus(FileStatus.ACTIVE);
        userImage.setExtension(getExtension(multipartFile.getOriginalFilename()));
        if(userId != null){
            userImage.setUserId(userId);
        }
        userImageRepo.save(userImage);

        File uploadFile = new File(String.format("%s/uploadUserImage/", uploadPathFolder));
        if(!uploadFile.exists() && uploadFile.mkdirs()){
            System.out.println("Papkalar yaratildi");
        }
        userImage.setHashId(hashids.encode(userImage.getId()));
        userImage.setUploadName(hashidsName.encode(userImage.getId()) + "." + userImage.getExtension());
        userImage.setUploadPath(String.format("uploadUserImage/%s.%s", hashidsName.encode(userImage.getId()), userImage.getExtension()));
        userImageRepo.save(userImage);

        uploadFile = uploadFile.getAbsoluteFile();
        File file = new File(uploadFile, String.format("%s.%s", hashidsName.encode(userImage.getId()), userImage.getExtension()));
        try {
            multipartFile.transferTo(file);
        }catch (IOException e){
            e.printStackTrace();
        }

        return ResponseEntity.ok(userImage);
    }

    private String getExtension(String name) {
        String ext = null;
        if(name != null && !name.isEmpty()){
            int dot = name.lastIndexOf('.');
            if(dot > 0 && dot <= name.length() -2){
                ext = name.substring(dot+1);
            }
        }
        return ext;
    }

    public UserImage findByHashId(String hashId) {
        return userImageRepo.findByHashId(hashId);
    }
}
