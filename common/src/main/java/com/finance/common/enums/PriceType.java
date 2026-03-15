package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PriceType {
    CLEAN("Clean"),
    DIRTY("Dirty");

    private final String code;

    PriceType(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static PriceType fromJson(String input) {
        for (PriceType t : values()) {
            if (t.name().equalsIgnoreCase(input) || t.code.equalsIgnoreCase(input)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown PriceType: " + input);
    }

    @JsonValue
    public String toJson() {
        return code;
    }
}