package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/*
 */
public enum CouponType {
    FIXED("Fixed"),
    FLOATING("Floating"),
    ZERO("Zero");

    private final String code;

    CouponType(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static CouponType fromJson(String input) {
        for (CouponType t : values()) {
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