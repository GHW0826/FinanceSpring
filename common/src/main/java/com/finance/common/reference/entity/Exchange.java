package com.finance.common.reference.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exchange")
public class Exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 거래소 코드
    @Column(name = "ExchangeCode")
    private String exchangeCode;
    
    // 거래소 이름
    @Column(name = "ExchangeName")
    private String name;

    // 비고
    @Column(name = "Description")
    private String description;
}
