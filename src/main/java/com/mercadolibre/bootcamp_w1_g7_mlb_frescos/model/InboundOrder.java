package com.mercadolibre.bootcamp_w1_g7_mlb_frescos.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InboundOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderNumber;

    @Column
    private LocalDate orderDate;

    @ManyToOne
    private Section section;

    @ManyToOne
    private WareHouse wareHouse;

    @ManyToOne
    private Supervisor supervisor;

}