package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/*
    ANNUAL,
    SEMI_ANNUAL,
    QUARTERLY,
    MONTHLY
 */
public enum CouponFrequency {
    ANNUAL("Annual"),
    SEMI_ANNUAL("SemiAnnual"),
    QUARTERLY("Quarterly"),
    MONTHLY("Monthly"),
    NONE("None");

    private final String code;

    CouponFrequency(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static CouponFrequency fromJson(String input) {
        for (CouponFrequency t : values()) {
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