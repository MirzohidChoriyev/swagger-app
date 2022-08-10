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
public class ProductWithAmount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date expireDate;

    private Date created_date;

    private double price;

    private int amount;

    private Integer transfer_id;

    private Integer sale_id;

    private Integer reject_id;

    private Integer product_id;
}
