package com.finance.common.market.entity.bond;

import com.finance.common.enums.CouponFrequency;
import com.finance.common.enums.CouponType;
import com.finance.common.enums.DayCountConvention;
import com.finance.common.market.entity.MarketMaster;
import com.finance.common.reference.entity.Issuer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(
    name = "market_bond",
    uniqueConstraints = {
            @UniqueConstraint(name = "uk_bond_master_isin", columnNames = {"isin"})
    },
    indexes = {
            @Index(name = "ix_bond_master_maturity_date", columnList = "maturity_date"),
            @Index(name = "ix_bond_master_issuer_name", columnList = "issuer_name")
    }
)
@DiscriminatorValue("BOND")
@PrimaryKeyJoinColumn(name = "id")
@Comment("채권 종목 마스터(정적 정보)")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor @AllArgsConstructor
public class MarketBond extends MarketMaster {
    @Column(name = "isin", length = 12)
    @Comment("ISIN")
    private String isin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issuer_id")
    @Comment("발행사")
    private Issuer issuer;

    @Column(name = "issue_date")
    @Comment("발행일")
    private LocalDate issueDate;

    @Column(name = "maturity_date", nullable = false)
    @Comment("만기일")
    private LocalDate maturityDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "coupon_type", nullable = false, length = 20)
    @Comment("쿠폰 타입(FIXED/FLOATING/ZERO)")
    private CouponType couponType;

    @Column(name = "coupon_rate", precision = 19, scale = 10)
    @Comment("쿠폰 금리(예: 0.025 = 2.5%)")
    private BigDecimal couponRate;

    @Enumerated(EnumType.STRING)
    @Column(name = "coupon_frequency", length = 20)
    @Comment("쿠폰 주기")
    private CouponFrequency couponFrequency;

    @Enumerated(EnumType.STRING)
    @Column(name = "day_count_convention", length = 20)
    @Comment("Day Count Convention")
    private DayCountConvention dayCountConvention;

    @Column(name = "face_value", precision = 19, scale = 2)
    @Comment("액면가/기준원금")
    private BigDecimal faceValue;

    @Column(name = "redemption", precision = 19, scale = 10)
    @Comment("상환값(보통 100.0)")
    private BigDecimal redemption;
}
