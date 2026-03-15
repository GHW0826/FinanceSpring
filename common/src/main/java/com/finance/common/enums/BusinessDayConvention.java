package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BusinessDayConvention  {
    FOLLOWING("Following"),
    MODIFIED_FOLLOWING("ModifiedFollowing"),
    PRECEDING("Preceding");

    private final String code;

    BusinessDayConvention(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static BusinessDayConvention fromJson(String input) {
        for (BusinessDayConvention t : values()) {
            if (t.name().equalsIgnoreCase(input) || t.code.equalsIgnoreCase(input)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown BusinessDayConvention: " + input);
    }

    @JsonValue
    public String toJson() {
        return code;
    }
}