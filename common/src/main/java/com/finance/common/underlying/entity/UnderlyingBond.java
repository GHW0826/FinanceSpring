package com.finance.common.underlying.entity;


import com.finance.common.reference.entity.CurrencyMaster;
import com.finance.common.enums.AssetSecuritizationClassification;
import com.finance.common.enums.InterestPayMethod;
import com.finance.common.enums.SubordinationClassification;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "UnderlyingBond")
@DiscriminatorValue("BOND")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnderlyingBond extends Underlying {

    // 발행기관코드
    @Column(name = "IssuerCode")
    private String issuerCode;

    // ISIN Code
    @Column(name = "ISINCode")
    private String isinCode;

    // 통화 (마스터 FK)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CurrencyId", nullable = false)
    private CurrencyMaster currency;

    // 이자지급방법
    @Column(name = "InterestPayMethod")
    @Enumerated(EnumType.STRING)
    private InterestPayMethod interestPayMethod;

    // 자산유동화구분
    @Column(name = "AssetSecuritizationClassification")
    @Enumerated(EnumType.STRING)
    private AssetSecuritizationClassification assetSecuritizationClassification;

    // 선후순위구분
    @Column(name = "SubordinationClassification")
    @Enumerated(EnumType.STRING)
    private SubordinationClassification subordinationClassification;

    // 발행일
    @Column(name = "IssueDate")
    @Temporal(TemporalType.DATE) // 날짜만 저장이면 DATE (시간까지면 TIMESTAMP)
    private Date issueDate;

    // 만기일
    @Column(name = "MaturityDate")
    @Temporal(TemporalType.DATE)
    private Date maturityDate;

    // 채권종류
    @Column(name = "IssueKind")
    private String issueKind;

    // 채권발행목적
    @Column(name = "IssuePurpose")
    private String issuePurpose;

    @Column(name = "CouponRate")
    private BigDecimal couponRate;

    @Column(name = "DayCount")
    private String dayCount;

    @Column(name = "CouponFrequency")
    private String couponFrequency;

    @Column(name = "FaceValue")
    private BigDecimal faceValue;
}
