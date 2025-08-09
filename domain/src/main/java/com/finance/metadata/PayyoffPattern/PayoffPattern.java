package com.finance.metadata.PayyoffPattern;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name = "payoff_pattern")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PayoffPattern {
    @Id
    @Column(name="payoff_pattern_code", length = 20, nullable = false)
    private String code;

    @Column(name = "payoff_pattern_name", length = 100, nullable = false)
    private String name;
}
