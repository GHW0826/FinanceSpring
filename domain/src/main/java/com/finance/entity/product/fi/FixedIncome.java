package com.finance.entity.product.fi;

import com.finance.entity.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "FixedIncome")
@PrimaryKeyJoinColumn(name = "id")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class FixedIncome extends Product {
    private double baseRate;    // 채권 시작일
    private LocalDate startDate;      // 채권 만기일
    private LocalDate endDate;      // 채권 만기일
}
