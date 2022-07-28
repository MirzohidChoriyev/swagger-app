package com.example.swaggerapp.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String message;

    @NotNull
    private String comment;

    @Column(nullable = false)
    private String created_date;

    private boolean active;

    private boolean seen;

    @ManyToOne(fetch = FetchType.LAZY)
    private User sender;
}
