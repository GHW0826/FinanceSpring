package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/*
    ACT_360,
    ACT_365F,
    THIRTY_360
 */
public enum DayCountConvention {
    ACT_360("ACT360"),
    ACT_365F("ACT365F"),
    THIRTY_360("Thirty360");

    private final String code;

    DayCountConvention(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static DayCountConvention fromJson(String input) {
        for (DayCountConvention t : values()) {
            if (t.name().equalsIgnoreCase(input) || t.code.equalsIgnoreCase(input)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown InterpolationMethod: " + input);
    }

    @JsonValue
    public String toJson() {
        return code;
    }
}