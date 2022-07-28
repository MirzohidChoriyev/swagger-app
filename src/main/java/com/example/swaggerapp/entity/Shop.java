package com.example.swaggerapp.entity;

import com.example.swaggerapp.entity.template.AbsTemplateName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@Entity
public class Shop extends AbsTemplateName {
    private String address;
    private Float lon;
    private Float lat;
    private String seller_username;

    @ManyToOne(fetch = FetchType.LAZY)
    private User seller;
}







