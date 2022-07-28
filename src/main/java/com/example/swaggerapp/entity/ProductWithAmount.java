package com.example.swaggerapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private Transfer transfer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Sale sale;

    @ManyToOne(fetch = FetchType.LAZY)
    private Reject reject;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
}
