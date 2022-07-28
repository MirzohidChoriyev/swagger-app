package com.example.swaggerapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
    private String name;
    private String description;
    private double incomePrice;
    private double salePrice;
    private boolean active = true;
    private Integer category_id;
    private int count;
    private int count_note;
    private String count_active = "A";
    private String valyuta;
}
