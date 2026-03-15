package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/*
    PAR_YIELD,          // 표면/파 수익률
    ZERO_RATE,          // 제로 수익률
    DISCOUNT_FACTOR,    // 할인계수
    Z_SPREAD,           // Z-Spread
    G_SPREAD,           // G-Spread
    OAS                 // Option Adjusted Spread
 */
public enum CurveRateRepresentation {
    PAR_YIELD("ParYield"),
    ZERO_RATE("ZeroRate"),
    DISCOUNT_FACTOR("DiscountFactor"),
    Z_SPREAD("ZSpread"),
    G_SPREAD("GSpread"),
    OAS("OAS");

    private final String code;

    CurveRateRepresentation(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static CurveRateRepresentation fromJson(String input) {
        for (CurveRateRepresentation t : values()) {
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