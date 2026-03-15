package com.finance.common.market.entity;

import com.finance.common.common.entity.BaseEntity;
import com.finance.common.market.entity.trading.TradingMarketContext;
import com.finance.common.market.entity.valuation.ValuationMarketContext;
import com.finance.common.reference.entity.CurrencyMaster;
import com.finance.common.reference.entity.Vendor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

// 마켓종목마스터
@Entity
@Table(
    name = "market_master",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_market_master_market_code", columnNames = {"market_code"}),
        @UniqueConstraint(name = "uk_market_master_vendor_code", columnNames = {"vendor_id", "vendor_code"})
    },
    indexes = {
        @Index(name = "ix_market_master_name", columnList = "name"),
        @Index(name = "ix_market_master_vendor", columnList = "vendor_id")
    }
)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "asset_type", length = 20)
@Comment("마켓 종목 마스터(공통)")
@Data @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MarketMaster extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("대리키 PK")
    private Long id;

    @Column(name = "market_code", nullable = false, length = 64)
    @Comment("내부 표준 종목 코드(유니크)")
    private String marketCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id")
    @Comment("마켓데이터 벤더(FK)")
    private Vendor vendor;

    @Column(name = "name", nullable = false, length = 255)
    @Comment("종목명")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "currency_id", nullable = false)
    @Comment("통화(FK)")
    private CurrencyMaster currency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "default_trading_context_id")
    @Comment("기본 거래 컨텍스트(FK: trading_market_context 계열)")
    private TradingMarketContext defaultTradingContext;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "default_valuation_context_id")
    @Comment("기본 평가 컨텍스트(FK: valuation_market_context 계열)")
    private ValuationMarketContext defaultValuationContext;

    @Column(name = "description")
    @Comment("비고")
    private String description;
}
