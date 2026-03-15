package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/*
    ANNUAL,
    SEMI_ANNUAL,
    QUARTERLY,
    MONTHLY
 */
public enum CompoundingFrequency {
    ANNUAL("Annual"),
    SEMI_ANNUAL("SemiAnnual"),
    QUARTERLY("Quarterly"),
    MONTHLY("Monthly");

    private final String code;

    CompoundingFrequency(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static CompoundingFrequency fromJson(String input) {
        for (CompoundingFrequency t : values()) {
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