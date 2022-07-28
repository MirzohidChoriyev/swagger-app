package com.example.swaggerapp.entity;

import com.example.swaggerapp.entity.template.AbsTemplate;
import com.example.swaggerapp.enums.PayType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@Entity
public class Payment extends AbsTemplate {
    private double paySum;

    @Enumerated(EnumType.STRING)
    private PayType payType;
}
