package com.example.swaggerapp.entity;

import com.example.swaggerapp.entity.template.AbsTemplate;
import com.example.swaggerapp.entity.template.AbsTemplateName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@Entity
public class Customer extends AbsTemplateName {
    private String phoneNumber;

    @CreationTimestamp
    @Column(nullable = false)
    private Timestamp created_time;

    private double summa;

    @ManyToOne(fetch = FetchType.LAZY)
    private PayType payType;
}




