package com.example.swaggerapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {
    private String phoneNumber;
    private Timestamp created_time;
    private double summa;
    private Integer pay_id;
    private String name;
    private String description;
    private boolean active;
}
