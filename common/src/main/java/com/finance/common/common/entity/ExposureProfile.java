package com.finance.common.common.entity;

import com.finance.common.product.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "ExposureProfile")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExposureProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private NettingSet nettingSet;

    private LocalDate timePoint;

    private BigDecimal expectedExposure;

    private BigDecimal potentialFutureExposure;
}
