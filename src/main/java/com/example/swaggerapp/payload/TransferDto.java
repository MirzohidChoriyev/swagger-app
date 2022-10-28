package com.example.swaggerapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
