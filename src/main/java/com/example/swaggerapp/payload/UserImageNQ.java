package com.example.swaggerapp.payload;

import com.example.swaggerapp.enums.FileStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserImageNQ {
    private String name;
    private String uploadName;
    private Long fileSize;
    private String contentType;
    private String extension;
    private String hashId;
    private String uploadPath;
    private Integer userId;
    private FileStatus fileStatus;
    private Timestamp createdDate;
    private String fullname;
}
