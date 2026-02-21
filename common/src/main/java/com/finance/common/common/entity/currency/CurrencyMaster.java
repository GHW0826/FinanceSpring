package com.finance.common.common.entity.currency;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// 통화 마스터 테이블
@Entity
@Table(name = "CurrencyMaster")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyMaster {
    @Id
    @Column(name = "Ccy", length = 3, nullable = false)
    private String Ccy;

    @Column(name = "Description", length = 200)
    private String Description;
}
