package com.finance.common.market.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "YieldCurve")
public class YieldCurve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Name
    @Column(name = "Name")
    private String name;
}