package com.finance.common.common.entity;

import com.finance.common.product.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "RiskFactor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RiskFactor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String factorName;

    private String assetClass; // IR, FX, Credit

    private String regulatoryBucket;

    private Integer liquidityHorizon;
}
