package com.finance.common.common.entity;

import com.finance.common.market.entity.CreditCurve;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "Counterparty")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Counterparty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Code
    @Column(name = "CounterpartyCode")
    private String counterpartyCode;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;
}
