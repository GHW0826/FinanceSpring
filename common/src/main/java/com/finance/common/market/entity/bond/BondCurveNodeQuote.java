package com.finance.common.market.entity.bond;

import com.finance.common.common.entity.BaseEntity;
import com.finance.common.enums.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 채권 커브 입력 노드(Constituents) 호가 저장.
 *
 * 의미:
 * - 어떤 스냅샷(SnapshotId)에 대해
 * - 어떤 채권(BondId)을 구성종목으로 사용했고
 * - 그 입력이 PRICE인지 YIELD인지(QuoteType)
 * - Bid/Ask/Mid가 얼마였는지
 * 를 저장한다.
 *
 * 입력이 PRICE/YIELD 둘 다 가능한 요구사항을 만족:
 * - QuoteType=PRICE 인 경우: PriceType(CLEAN/DIRTY)와 QuoteUnit=PRICE_POINTS를 주로 사용
 * - QuoteType=YIELD 인 경우: QuoteUnit=PERCENT/DECIMAL/BP 중 선택
 */
@Getter
@Setter
@Entity
@Table(
    name = "bond_curve_node_quote",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_bond_curve_node_quote_snapshot_node_seq",
            columnNames = {"bond_curve_snapshot_id", "node_seq"}
        ),
        @UniqueConstraint(
            name = "uk_bond_curve_node_quote_snapshot_bond_id",
            columnNames = {"bond_curve_snapshot_id", "bond_id"}
        )
    },
    indexes = {
        @Index(name = "ix_bond_curve_node_quote_snapshot_id", columnList = "bond_curve_snapshot_id"),
        @Index(name = "ix_bond_curve_node_quote_maturity_date", columnList = "maturity_date")
    }
)
@Comment("채권 커브 입력 노드 호가")
public class BondCurveNodeQuote extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bond_curve_node_quote_id")
    @Comment("입력 노드 PK")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
        name = "bond_curve_snapshot_id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_bond_curve_node_quote_snapshot")
    )
    @Comment("어떤 스냅샷의 입력 노드인지")
    private BondCurveSnapshot snapshot;

    @Column(name = "node_seq", nullable = false)
    @Comment("노드 순서")
    private Integer nodeSeq;

    @Column(name = "bond_id", nullable = false)
    @Comment("입력 채권 ID(BondMaster PK 가정)")
    private Long bondId;

    @Column(name = "maturity_date", nullable = false)
    @Comment("채권 만기일")
    private LocalDate maturityDate;

    @Column(name = "pillar_label", length = 16)
    @Comment("표시용 라벨. 예: 3Y, 5Y")
    private String pillarLabel;

    @Enumerated(EnumType.STRING)
    @Column(name = "quote_type", length = 16, nullable = false)
    @Comment("입력 타입(PRICE / YIELD)")
    private BondQuoteType quoteType;

    @Enumerated(EnumType.STRING)
    @Column(name = "price_type", length = 16)
    @Comment("PRICE 입력일 때 CLEAN / DIRTY")
    private BondPriceType priceType;

    @Column(name = "bid_value", precision = 18, scale = 10)
    @Comment("Bid 값")
    private BigDecimal bidValue;

    @Column(name = "ask_value", precision = 18, scale = 10)
    @Comment("Ask 값")
    private BigDecimal askValue;

    @Column(name = "mid_value", precision = 18, scale = 10)
    @Comment("Mid 값")
    private BigDecimal midValue;

    @Enumerated(EnumType.STRING)
    @Column(name = "quote_unit", length = 16, nullable = false)
    @Comment("입력 단위")
    private BondQuoteUnit quoteUnit;

    @Column(name = "included", nullable = false)
    @Comment("실제 커브 피팅에 포함되었는지 여부")
    private boolean included = true;

    @Column(name = "exclude_reason", length = 256)
    @Comment("제외 사유")
    private String excludeReason;

    protected BondCurveNodeQuote() {}
}