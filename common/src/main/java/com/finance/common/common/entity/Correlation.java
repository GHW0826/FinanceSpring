package com.finance.common.common.entity;

import com.finance.common.product.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


// 상관관계
@Entity
@Table(name = "Correlation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Correlation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private RiskFactor factor1;

    @ManyToOne
    private RiskFactor factor2;

    private BigDecimal correlationValue;
}
