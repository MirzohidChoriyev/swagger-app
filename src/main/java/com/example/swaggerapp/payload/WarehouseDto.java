package com.example.swaggerapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WarehouseDto {
    private String address;
    private Float lon;
    private Float lat;
    private Integer shop_id;
    private Integer user_id;
    private String name;
    private String description;
    private boolean active;
}
