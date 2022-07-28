package com.example.swaggerapp.payload;

import com.example.swaggerapp.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShopDto {
    private String address;
    private Float lon;
    private Float lat;
    private String seller_username;
    private Integer seller_id;
    private String name;
    private String description;
    private boolean active;
}
