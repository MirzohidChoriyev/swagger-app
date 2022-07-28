package com.example.swaggerapp.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    private News news;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String send_date;
}
