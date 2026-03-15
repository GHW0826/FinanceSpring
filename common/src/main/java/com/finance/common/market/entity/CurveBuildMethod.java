package com.finance.common.market.entity;

import com.finance.common.common.entity.BaseEntity;
import com.finance.common.enums.*;
import com.finance.common.reference.entity.calendar.Calendar;
import jakarta.persistence.*;

/**
 * 채권 커브 산출 방법론/컨벤션(레시피)을 정의한다.
 * - 같은 입력 PRICE/YIELD라도 보간/외삽/피팅/컨벤션에 따라 결과(YTM/ZERO/DF)가 달라질 수 있어
 *   "재현성"을 위해 별도 관리한다.
 */
@Entity
@Table(name = "CurveBuildMethod")
public class CurveBuildMethod extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 방법론 이름 (예: KRW_OIS_LOGLINEAR_DF) */
    @Column(name = "Name", nullable = false)
    private String name;

    /** 보간 방식 */
    @Enumerated(EnumType.STRING)
    @Column(name = "InterpolationMethod", nullable = false)
    private InterpolationMethod interpolationMethod;

    /** 외삽 방식 */
    @Enumerated(EnumType.STRING)
    @Column(name = "ExtrapolationMethod", nullable = false)
    private ExtrapolationMethod extrapolationMethod;

    /** 부트스트랩 알고리즘 */
    @Enumerated(EnumType.STRING)
    @Column(name = "BootstrapAlgorithm", nullable = false)
    private BootstrapAlgorithm bootstrapAlgorithm;

    /** Day Count */
    @Enumerated(EnumType.STRING)
    @Column(name = "DayCount", nullable = false)
    private DayCountConvention dayCount;

    /**
     * YTM/Zero의 컴파운딩 타입
     * - 시장 관행(연속복리 vs 복리 등)에 따라 값이 달라짐
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "CompoundingType", nullable = false, length = 32)
    private CompoundingType compoundingType;

    /** 복리 주기(예: 국채는 semi-annual 관행이 흔함) */
    @Enumerated(EnumType.STRING)
    @Column(name = "CompoundingFrequency", length = 32)
    private CompoundingFrequency compoundingFrequency;

    /** 영업일 규칙 */
    @Enumerated(EnumType.STRING)
    @Column(name = "BusinessDayConvention", nullable = false)
    private BusinessDayConvention businessDayConvention;

    /** 캘린더 (휴일/영업일) */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CalendarId")
    private Calendar calendar;

    /**
     * 결제일(spot lag) - 예: T+2면 2
     * - 채권 가격/수익률 계산 시 settlement 기준이 중요할 수 있음
     */
    @Column(name = "SettlementDays")
    private Integer settlementDays;

    /** 메모 */
    @Column(name = "Description", length = 2000)
    private String description;

    protected CurveBuildMethod() {}
}