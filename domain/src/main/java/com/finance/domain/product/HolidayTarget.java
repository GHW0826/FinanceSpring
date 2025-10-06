package com.finance.domain.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


public enum HolidayTarget {
    ACCRUALFIXING("A"),     // Accrual Fixing
    COUPONPERIOD("C"),      // Coupon Period
    FLOATER("F"),           // Floater
    PERIOD("P"),            // Period
    SETTLEMENT("S"),        // Swaption Settlement, Bond Settlement
    TIGGERFIXING("T"),      // Tigger Underlying Fixing
    SWAPTIONSWAPPERIOD("W");// Swaption's Swap Period

    private final String code;

    HolidayTarget(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static HolidayTarget fromJson(String input) {
        for (HolidayTarget t : values()) {
            if (t.name().equalsIgnoreCase(input) || t.code.equalsIgnoreCase(input)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown HolidayTarget: " + input);
    }

    @JsonValue
    public String toJson() {
        return code;
    }
}