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
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Sale extends AbsTemplate {
    @ManyToOne(fetch = FetchType.LAZY)
    private User seller;

    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;

    @ManyToOne(fetch = FetchType.LAZY)
    private Report report;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    private PayType payType;

    @ManyToOne(fetch = FetchType.LAZY)
    private PayStatus payStatus;
}
