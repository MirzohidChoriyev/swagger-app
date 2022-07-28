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
public class Defect extends AbsTemplate {
    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;
}
