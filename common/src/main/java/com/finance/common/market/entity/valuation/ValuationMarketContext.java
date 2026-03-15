package com.finance.common.market.entity.valuation;

import com.finance.common.reference.entity.Vendor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;

@Entity
@Table(name = "valuation_market_context")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "asset_type", length = 20)
@Comment("평가 시장 컨텍스트(공통)")
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class ValuationMarketContext {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("대리키 PK")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id")
    @Comment("평가/가격 벤더(FK)")
    private Vendor vendor;

    @Column(name = "effective_from", nullable = false)
    @Comment("효력 시작일")
    private LocalDate effectiveFrom;

    @Column(name = "effective_to")
    @Comment("효력 종료일(NULL이면 무기한)")
    private LocalDate effectiveTo;

    @Column(name = "description")
    @Comment("비고")
    private String description;
}