package com.example.swaggerapp.entity;

import com.example.swaggerapp.enums.Condition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id", nullable = false)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Status status = Status.valueOf("A");

    private String card_name;
    private String card_number;
    private String bank_name;
    private String embossed_name;

    private String open_date;
    private String term_date;
    private Date createDate;

    private Double card_money = Double.valueOf(0);

    @Column(nullable = false)
    private Integer user_id;

    @Enumerated(EnumType.STRING)
    private Condition  condition = Condition.valueOf("M");
}
