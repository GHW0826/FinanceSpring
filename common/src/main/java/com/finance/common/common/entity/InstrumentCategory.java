package com.finance.common.common.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "instrument_category")
public class InstrumentCategory {
    @Id
    @Column(name = "instrument_group_code", length = 30, nullable = false)
    private String instrumentGroupCode;
    /*


    @Id
    @Column(name = "asset_group_code", length = 30, nullable = false)
    private String assetGroupCode;

    @Id
    @Column(name = "payoff_pattern_code", length = 30, nullable = false)
    private String payoffPatternCode;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

     */
}