package com.finance.common.market.entity.bond;

import com.finance.common.enums.CurvePurpose;
import com.finance.common.enums.CurveRateRepresentation;
import com.finance.common.enums.CurveType;
import com.finance.common.market.entity.Curve;
import com.finance.common.reference.entity.CurrencyMaster;
import com.finance.common.reference.entity.Issuer;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(
    name = "bond_curve",
    indexes = {
        @Index(name = "ix_bond_curve_issuer_id", columnList = "issuer_id")
    }
)
@PrimaryKeyJoinColumn(name = "curve_id")
@DiscriminatorValue("BOND_CURVE")
@Comment("채권 커브 마스터")
public class BondCurve extends Curve {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "issuer_id", nullable = false)
    @Comment("커브가 대표하는 issuer 또는 issuer group")
    private Issuer issuer;

    @Column(name = "on_the_run_only", nullable = false)
    @Comment("최근물(on-the-run)만 사용할지 여부")
    private boolean onTheRunOnly = false;

    @Column(name = "min_remaining_years", precision = 10, scale = 4)
    @Comment("최소 잔존만기(년) 필터")
    private BigDecimal minRemainingYears;

    @Column(name = "min_outstanding_amount", precision = 20, scale = 2)
    @Comment("최소 발행잔액 필터")
    private BigDecimal minOutstandingAmount;

    @Column(name = "output_includes_ytm", nullable = false)
    @Comment("산출에 YTM 저장 여부")
    private boolean outputIncludesYtm = true;

    @Column(name = "output_includes_zero", nullable = false)
    @Comment("산출에 Zero Rate 저장 여부")
    private boolean outputIncludesZero = true;

    @Column(name = "output_includes_df", nullable = false)
    @Comment("산출에 Discount Factor 저장 여부")
    private boolean outputIncludesDf = true;

    protected BondCurve() {}
}