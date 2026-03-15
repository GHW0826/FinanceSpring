package com.finance.common.market.entity.bond;

import com.finance.common.common.entity.BaseEntity;
import com.finance.common.enums.BondCurvePointQuality;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 채권 커브 산출 포인트 저장(소비자 엔진이 바로 쓰는 결과).
 *
 * 요구사항 반영:
 * - 같은 스냅샷에서 YTM 커브 + ZERO 커브 + DF 커브를 함께 저장 가능
 *
 * 해석 가이드(운영 규칙 추천):
 * - Ytm 값: 해당 만기(pillarDate)에서의 "커브 상 YTM" (연율)
 * - ZeroRate: 해당 만기(pillarDate)에서의 "제로금리" (연율)
 * - DiscountFactor: valuationDate -> pillarDate 할인계수
 */

@Getter
@Setter
@Entity
@Table(
    name = "bond_curve_point",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_bond_curve_point_snapshot_pillar_date",
            columnNames = {"bond_curve_snapshot_id", "pillar_date"}
        )
    },
    indexes = {
        @Index(name = "ix_bond_curve_point_snapshot_id", columnList = "bond_curve_snapshot_id"),
        @Index(name = "ix_bond_curve_point_pillar_date", columnList = "pillar_date")
    }
)
@Comment("채권 커브 산출 포인트(YTM / ZERO / DF)")
public class BondCurvePoint extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bond_curve_point_id")
    @Comment("산출 포인트 PK")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
        name = "bond_curve_snapshot_id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_bond_curve_point_snapshot")
    )
    @Comment("어떤 스냅샷의 산출 포인트인지")
    private BondCurveSnapshot snapshot;

    @Column(name = "pillar_date", nullable = false)
    @Comment("포인트 날짜(만기 축)")
    private LocalDate pillarDate;

    @Column(name = "tenor_label", length = 16)
    @Comment("표시용 라벨. 예: 1Y, 2Y")
    private String tenorLabel;

    @Column(name = "ytm_value", precision = 18, scale = 12)
    @Comment("YTM 값")
    private BigDecimal ytmValue;

    @Column(name = "zero_rate_value", precision = 18, scale = 12)
    @Comment("Zero Rate 값")
    private BigDecimal zeroRateValue;

    @Column(name = "discount_factor_value", precision = 18, scale = 16)
    @Comment("Discount Factor 값")
    private BigDecimal discountFactorValue;

    @Column(name = "instant_forward_rate_value", precision = 18, scale = 12)
    @Comment("즉시 포워드 값(선택)")
    private BigDecimal instantForwardRateValue;

    @Column(name = "extrapolated", nullable = false)
    @Comment("외삽 구간 여부")
    private boolean extrapolated = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "point_quality", length = 32, nullable = false)
    @Comment("포인트 품질 플래그")
    private BondCurvePointQuality pointQuality = BondCurvePointQuality.OK;

    protected BondCurvePoint() {}
}