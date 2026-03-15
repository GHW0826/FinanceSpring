package com.finance.common.market.entity;

import com.finance.common.common.entity.BaseEntity;
import com.finance.common.enums.CurvePurpose;
import com.finance.common.enums.CurveType;
import com.finance.common.enums.RateRepresentation;
import com.finance.common.reference.entity.CurrencyMaster;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(
    name = "curve",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_curve_curve_code", columnNames = "curve_code")
    },
    indexes = {
        @Index(name = "ix_curve_curve_code", columnList = "curve_code"),
        @Index(name = "ix_curve_currency_id", columnList = "currency_id"),
        @Index(name = "ix_curve_curve_type", columnList = "curve_type"),
        @Index(name = "ix_curve_curve_purpose", columnList = "curve_purpose")
    }
)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "asset_type")
@Comment("커브 공통 마스터")
public abstract class Curve extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curve_id")
    @Comment("커브 PK")
    private Long id;

    @Column(name = "curve_code", length = 64, nullable = false)
    @Comment("내부 커브 코드(업무키)")
    private String curveCode;

    @Column(name = "name", length = 256, nullable = false)
    @Comment("커브명")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "currency_id", nullable = false)
    @Comment("통화 마스터 FK")
    private CurrencyMaster currency;


    @Enumerated(EnumType.STRING)
    @Column(name = "curve_type", length = 32, nullable = false)
    @Comment("커브 유형")
    private CurveType curveType;

    @Enumerated(EnumType.STRING)
    @Column(name = "curve_purpose", length = 32, nullable = false)
    @Comment("커브 용도")
    private CurvePurpose curvePurpose;

    @Enumerated(EnumType.STRING)
    @Column(name = "rate_representation", length = 32, nullable = false)
    @Comment("대표 표현 방식")
    private RateRepresentation rateRepresentation;

    @Column(name = "active", nullable = false)
    @Comment("사용 여부")
    private boolean active = true;

    @Column(name = "valid_from")
    @Comment("유효 시작일")
    private LocalDate validFrom;

    @Column(name = "valid_to")
    @Comment("유효 종료일")
    private LocalDate validTo;

    @Column(name = "description", length = 2000)
    @Comment("비고")
    private String description;

    protected Curve() {}
}