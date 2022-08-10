package com.example.swaggerapp.entity;

import com.example.swaggerapp.enums.FileStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class UserImage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String uploadName;
    private Long fileSize;
    private String contentType;
    private String extension;
    private String hashId;
    private String uploadPath;
    private Integer userId;

    @Enumerated(EnumType.STRING)
    private FileStatus fileStatus;

    @CreationTimestamp
    @Column(name = "createdDate", nullable = false, updatable = false)
    private Timestamp createdDate;
}
