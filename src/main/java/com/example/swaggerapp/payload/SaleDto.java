package com.example.swaggerapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleDto {
    private Integer seller_id;
    private Integer shop_id;
    private Integer report_id;
    private Integer customer_id;
    private Integer payType_id;
    private Integer payStatus_id;
}


