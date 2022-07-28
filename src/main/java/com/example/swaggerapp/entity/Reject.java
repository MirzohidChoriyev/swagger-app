package com.example.swaggerapp.entity;

import com.example.swaggerapp.entity.template.AbsTemplate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.util.Lazy;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@Entity
public class Reject extends AbsTemplate {
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;

    private boolean approved;
}

