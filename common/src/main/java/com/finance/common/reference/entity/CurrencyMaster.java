package com.finance.common.reference.entity;

import com.finance.common.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;


// 통화 마스터 테이블
@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "currency_master")
public class CurrencyMaster extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "currency_id")
    private Long id;

    @Column(name = "currency_code", length = 3, nullable = false)
    @Comment("통화 코드 (예: KRW, USD)")
    private String currencyCode;

    @Column(name = "name", length = 128, nullable = false)
    @Comment("통화명 (예: Korean Won)")
    private String name;

    @Column(name = "description", length = 2000)
    @Comment("비고/운영 메모")
    private String description;

    protected CurrencyMaster() {}

    public void update(String currencyCode, String name, String description) {
        this.currencyCode = currencyCode;
        this.name = name;
        this.description = description;
    }
}