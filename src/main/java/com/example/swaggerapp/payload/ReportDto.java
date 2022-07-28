package com.example.swaggerapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReportDto {
    private boolean approved;
    private Integer user_id;
    private Integer shop_id;
}
