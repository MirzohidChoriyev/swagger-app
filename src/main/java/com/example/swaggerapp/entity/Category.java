package com.example.swaggerapp.entity;

import com.example.swaggerapp.entity.template.AbsTemplateName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private boolean active;

    @OneToOne(fetch = FetchType.LAZY)
    private Attachment photo;
}
