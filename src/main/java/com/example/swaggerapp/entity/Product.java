package com.example.swaggerapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private double incomePrice;
    private double salePrice;
    private String valyuta;
    private boolean active;

    private Date createdDate;

    @OneToOne(fetch = FetchType.LAZY)
    private Attachment photo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    private int count;
    private int count_note;
    private String count_active;
    private int all_count;
}
