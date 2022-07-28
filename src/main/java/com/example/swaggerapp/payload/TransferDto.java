package com.example.swaggerapp.payload;

import com.example.swaggerapp.entity.Supplier;
import com.example.swaggerapp.entity.Warehouse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransferDto {

    private Integer fromWarehouse_id;

    private Integer toWarehouse_id;

    private boolean approved;

    private Integer supplier_id;

    private String agentName;

    private String agentPhoneNumber;
}
