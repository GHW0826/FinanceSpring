package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/*
    PRICE_POINTS,   // 채권 가격 포인트 단위(보통 Face 100 기준의 가격)
                    // * 예: 101.25 = 100 기준 101.25
    DECIMAL         // 0.035 같은 소수(decimal)
    PERCENT         // 35bp 같은 베이시스포인트
    BP              // 35bp 같은 베이시스포인트
 */
/**
 * 입력 호가의 단위를 명확히 해서 혼선을 방지한다.
 */
public enum BondQuoteUnit {
    PRICE_POINTS("PricePoints"),
    DECIMAL("Decimal"),
    PERCENT("Percent"),
    BP("BP");

    private final String code;

    BondQuoteUnit(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static BondQuoteUnit fromJson(String input) {
        for (BondQuoteUnit t : values()) {
            if (t.name().equalsIgnoreCase(input) || t.code.equalsIgnoreCase(input)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown CurveType: " + input);
    }

    @JsonValue
    public String toJson() {
        return code;
    }
}