package com.finance.common.market.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CreditCurve")
public class CreditCurve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Name
    @Column(name = "Name")
    private String name;

    @OneToMany(mappedBy = "creditCurve")
    private List<CreditCurvePoint> points;
}