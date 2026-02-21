package com.finance.common.market.entity;

import com.finance.common.common.entity.currency.CurrencyMaster;
import com.finance.common.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


// 채권종목마스터
@Entity
@Table(name = "MarketDataBondMaster")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarketDataBondMaster {
    @Id
    @Column(name = "MarketDataCode")
    private String marketDataCode;

    @Column(name = "Name")
    private String name;

    // 발행기관코드
    @Column(name = "IssuerCode")
    private String issuerCode;

    //
    @Column(name = "ISINCode")
    private String isinCode;

    // 상장 구분
    @Column(name = "ListingSection")
    @Enumerated(EnumType.STRING) // DB 저장 타입이 문자열이면 유지 (숫자면 ORDINAL로 바꿔야 함)
    private ListingSection listingSection;

    // 통화 (마스터 FK)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Ccy", referencedColumnName = "Ccy", nullable = false)
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

    // 제공처코드
    @Column(name = "SourceCode")
    private String sourceCode;

    // 출처코드
    @Column(name = "OriginSourceCode")
    @Enumerated(EnumType.STRING)
    private SourceCode originSourceCode;

    // 채권종류
    @Column(name = "IssueKind")
    private String issueKind;

    // 채권발행목적
    @Column(name = "IssuePurpose")
    private String issuePurpose;

    // 비고
    @Column(name = "Description")
    private String description;
}