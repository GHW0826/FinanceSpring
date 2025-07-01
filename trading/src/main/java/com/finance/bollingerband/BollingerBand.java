package com.finance.bollingerband;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "bollinger_band")
public class BollingerBand {
    @Id
    @GeneratedValue
    private Long id;

    private String symbol;
    private int period;
    private double middle;
    private double upper;
    private double lower;
    private Date calculatedAt;

    // getters/setters 생략
}