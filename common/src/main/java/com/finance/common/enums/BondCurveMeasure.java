package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/*
    YTM,        // 만기수익률 기반 커브(벤치마크/리포팅에 자주 씀)
    ZERO_RATE,  // 제로금리 커브(프라이싱/리스크에 자주 씀)
    DISCOUNT_FACTOR // DF 커브(할인 목적일 때)
 */
public enum BondCurveMeasure {
    YTM("YTM"),
    ZERO_RATE("ZeroRate"),
    DISCOUNT_FACTOR("DiscountFactor");

    private final String code;

    BondCurveMeasure(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static BondCurveMeasure fromJson(String input) {
        for (BondCurveMeasure t : values()) {
            if (t.name().equalsIgnoreCase(input) || t.code.equalsIgnoreCase(input)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown BondCurveMeasure: " + input);
    }

    @JsonValue
    public String toJson() {
        return code;
    }
}