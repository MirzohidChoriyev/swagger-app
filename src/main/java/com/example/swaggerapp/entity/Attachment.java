package com.example.swaggerapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String contentType;
    private long size;
    private String url;

    public Attachment(String name, String contentType, long size) {
        this.name = name;
        this.contentType = contentType;
        this.size = size;
    }

    public Attachment(String name, String contentType, long size, String s) {
        this.name = name;
        this.contentType = contentType;
        this.size = size;
        this.url = s;
    }
}


