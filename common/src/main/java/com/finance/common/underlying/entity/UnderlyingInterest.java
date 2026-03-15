package com.finance.common.underlying.entity;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "UnderlyingInterest")
@DiscriminatorValue("Interest")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnderlyingInterest extends Underlying {
    private String referenceRate; // LIBOR, SOFR
    private String tenor;         // 3M, 6M
}
