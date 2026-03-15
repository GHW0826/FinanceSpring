package com.finance.common.underlying.entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "UnderlyingForeignExchange")
@DiscriminatorValue("Interest")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnderlyingForeignExchange extends Underlying {
    private String baseCurrency;
    private String quoteCurrency;
}
