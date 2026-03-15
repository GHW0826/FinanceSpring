package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/*
    OFFICIAL,   // 거래소/공식 발표
    EVALUATED,  // 평가기관 산출
    FITTED,     // 피팅/모델 산출
    INTERNAL    // 내부 엔진 산출
 */
public enum BondCurveSourceType {
    OFFICIAL("Official"),
    EVALUATED("Evaluated"),
    FITTED("Fitted"),
    INTERNAL("Internal");

    private final String code;

    BondCurveSourceType(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static BondCurveSourceType fromJson(String input) {
        for (BondCurveSourceType t : values()) {
            if (t.name().equalsIgnoreCase(input) || t.code.equalsIgnoreCase(input)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown BondCurveSourceType: " + input);
    }

    @JsonValue
    public String toJson() {
        return code;
    }
}