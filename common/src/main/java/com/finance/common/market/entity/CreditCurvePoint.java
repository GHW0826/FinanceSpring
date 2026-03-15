package com.finance.common.market.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "CreditCurve")
public class CreditCurvePoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Name
    @Column(name = "Name")
    private String name;


    private Integer tenorMonth;

    private BigDecimal hazardRate;

    private BigDecimal survivalProbability;

    @ManyToOne
    private CreditCurve creditCurve;
}