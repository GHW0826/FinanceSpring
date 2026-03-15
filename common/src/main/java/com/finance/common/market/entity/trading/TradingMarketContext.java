package com.finance.common.market.entity.trading;

import com.finance.common.reference.entity.Exchange;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;

@Entity
@Table(name = "trading_market_context")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "asset_type", length = 20)
@Comment("거래 시장 컨텍스트(공통)")
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class TradingMarketContext {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "exchange_id", nullable = false)
    @Comment("거래소(FK)")
    private Exchange exchange;

    @Column(name = "settlement_days")
    @Comment("결제일(T+N) - 예: 2면 T+2")
    private Integer settlementDays;

    @Column(name = "effective_from", nullable = false)
    @Comment("효력 시작일")
    private LocalDate effectiveFrom;

    @Column(name = "effective_to")
    @Comment("효력 종료일(NULL이면 무기한)")
    private LocalDate effectiveTo;

    // 비고
    @Column(name = "Description")
    private String description;
}