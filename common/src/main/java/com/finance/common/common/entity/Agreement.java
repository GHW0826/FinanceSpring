package com.finance.common.common.entity;

import com.finance.common.product.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

// CSA
@Entity
@Table(name = "Agreement")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agreement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal threshold;

    private BigDecimal minimumTransferAmount;

    private BigDecimal haircut;
}
