package com.example.swaggerapp.entity;

import com.example.swaggerapp.entity.template.AbsTemplate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@Entity
public class Transfer extends AbsTemplate {

    @ManyToOne(fetch = FetchType.LAZY)
    private Warehouse fromWarehouse;

    @ManyToOne(fetch = FetchType.LAZY)
    private Warehouse toWarehouse;

    private boolean approved;

    @ManyToOne(fetch = FetchType.LAZY)
    private Supplier supplier;

    private String agentName;
    private String agentPhoneNumber;
}




