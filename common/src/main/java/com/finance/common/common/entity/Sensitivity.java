package com.finance.common.common.entity;

import com.finance.common.product.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "Sensitivity")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sensitivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private Product product;

    @ManyToOne
    private RiskFactor riskFactor;

    private BigDecimal delta;

    private BigDecimal vega;

    private BigDecimal curvature;
}
