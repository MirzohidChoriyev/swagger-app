package com.example.swaggerapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RejectDto {
    private String description;
    private Integer shop_id;
    private boolean approved;
}
