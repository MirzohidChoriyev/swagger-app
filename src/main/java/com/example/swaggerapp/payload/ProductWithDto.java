package com.example.swaggerapp.payload;

import com.example.swaggerapp.entity.Product;
import com.example.swaggerapp.entity.Reject;
import com.example.swaggerapp.entity.Sale;
import com.example.swaggerapp.entity.Transfer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductWithDto {
    private Integer product_id;

    private Date expireDate;

    private double price;

    private int amount;

    private Integer transfer_id;

    private Integer sale_id;

    private Integer reject_id;
}
