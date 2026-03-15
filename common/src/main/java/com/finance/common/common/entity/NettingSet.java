package com.finance.common.common.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "NettingSet")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NettingSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Counterparty counterparty;

    @ManyToOne
    private Agreement agreement;
}
