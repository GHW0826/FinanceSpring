package com.finance.common.market.entity.bond;

import com.finance.common.common.entity.BaseEntity;
import com.finance.common.enums.*;
import com.finance.common.reference.entity.calendar.Calendar;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;


@Getter
@Setter
@Entity
@Table(
    name = "bond_curve_build_method",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_bond_curve_build_method_code", columnNames = "build_method_code")
    },
    indexes = {
        @Index(name = "ix_bond_curve_build_method_code", columnList = "build_method_code")
    }
)
@Comment("채권 커브 산출 방법론/컨벤션")
public class BondCurveBuildMethod extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bond_curve_build_method_id")
    @Comment("방법론 PK")
    private Long id;

    @Column(name = "build_method_code", length = 64, nullable = false)
    @Comment("방법론 코드(업무키)")
    private String buildMethodCode;

    @Column(name = "name", length = 128, nullable = false)
    @Comment("방법론명")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "fitting_method", length = 32, nullable = false)
    @Comment("피팅 방식")
    private CurveFittingMethod fittingMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "interpolation_method", length = 32, nullable = false)
    @Comment("보간 방식")
    private InterpolationMethod interpolationMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "extrapolation_method", length = 32, nullable = false)
    @Comment("외삽 방식")
    private ExtrapolationMethod extrapolationMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "day_count_convention", length = 32, nullable = false)
    @Comment("Day Count Convention")
    private DayCountConvention dayCountConvention;

    @Enumerated(EnumType.STRING)
    @Column(name = "compounding_type", length = 32, nullable = false)
    @Comment("컴파운딩 방식")
    private CompoundingType compoundingType;

    @Enumerated(EnumType.STRING)
    @Column(name = "compounding_frequency", length = 32)
    @Comment("복리 빈도")
    private CompoundingFrequency compoundingFrequency;

    @Enumerated(EnumType.STRING)
    @Column(name = "business_day_convention", length = 32, nullable = false)
    @Comment("영업일 조정 규칙")
    private BusinessDayConvention businessDayConvention;

    /** 휴일 캘린더(FK) */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "calendar_id")
    @Comment("영업일 캘린더 FK")
    private Calendar calendar;

    @Column(name = "settlement_days")
    @Comment("결제일(T+N)")
    private Integer settlementDays;

    @Column(name = "active", nullable = false)
    @Comment("사용 여부")
    private boolean active = true;

    @Column(name = "description", length = 2000)
    @Comment("비고")
    private String description;

    protected BondCurveBuildMethod() {}
}