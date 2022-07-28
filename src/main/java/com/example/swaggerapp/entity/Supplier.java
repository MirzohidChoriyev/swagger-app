package com.example.swaggerapp.entity;

import com.example.swaggerapp.entity.template.AbsTemplate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Supplier{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String address;
    private String name;
    private Float lat;
    private Float lon;
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private User suppliers;

    private String supplier_username;
}
