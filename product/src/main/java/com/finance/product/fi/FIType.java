package com.finance.product.fi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FIType {
    FIFWDBFD("FIFWDBFD"),
    FINTSZER("FINTSZER");

    private final String code;

    FIType(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static FIType fromJson(String input) {
        for (FIType t : values()) {
            if (t.name().equalsIgnoreCase(input) || t.code.equalsIgnoreCase(input)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown ProductSect: " + input);
    }

    @JsonValue
    public String toJson() {
        return code;
    }
}