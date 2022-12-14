package com.example.swaggerapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ProductWithAmount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private double sale_all_price;

    private double income_all_price;

    private String currency;

    private int amount;

    private Integer transfer_id;

    private Integer sale_id;

    private Integer reject_id;

    private Integer product_id;

    @CreationTimestamp
    private Date created_date;
}
