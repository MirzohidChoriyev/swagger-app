package com.example.swaggerapp.controller;

import com.example.swaggerapp.entity.UserImage;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.repository.UserImageRepo;
import com.example.swaggerapp.service.UserImageService;
import com.example.swaggerapp.utils.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileUrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.net.URLEncoder;

@CrossOrigin(Paths.return_path)
@RestController
@RequestMapping("/api/userImage")
public class UserImageController {
    @Autowired
    UserImageService userImageService;

    @Autowired
    UserImageRepo userImageRepo;

    @Value("${upload.user_image_file.path}")
    private String uploadPathFolder;

    @PostMapping("/save/{userId}")
    public ResponseEntity fileSave(@RequestParam("image") MultipartFile multipartFile, @PathVariable Integer userId) {
        return ResponseEntity.ok(userImageService.save(multipartFile, userId));
    }

    @GetMapping("/readImage/{hashId}")
    public ResponseEntity getFileRead(@PathVariable String hashId) throws MalformedURLException {
        UserImage fileStorage = userImageService.findByHashId(hashId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; fileName=\"" + URLEncoder.encode(fileStorage.getName()))
                .contentType(MediaType.parseMediaType(fileStorage.getContentType()))
                .contentLength(fileStorage.getFileSize())
                .body(new FileUrlResource(String.format("%s/%s", uploadPathFolder, fileStorage.getUploadPath())));
    }

    @GetMapping("/readImageHashId/{userId}")
    public String readImageHashId(@PathVariable Integer userId) {
        return userImageRepo.findByUserIdNativeQuery(userId);
    }

    @DeleteMapping("/deleteFile/{hashId}")
    public ResponseEntity deleteFile(@PathVariable String hashId) {
        return ResponseEntity.ok(userImageService.delete(hashId));
    }

    @GetMapping("/allimage")
    public ApiResponse allImage(){
        return userImageService.getAll();
    }
}
