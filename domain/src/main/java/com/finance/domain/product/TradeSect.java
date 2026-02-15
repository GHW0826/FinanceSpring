package com.finance.domain.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TradeSect {
    External("External"),
    Internal("Internal"),
    Virtual("Virtual"),
    ContraInternal("ContraInternal");


    private final String code;

    TradeSect(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static TradeSect fromJson(String input) {
        for (TradeSect t : values()) {
            if (t.name().equalsIgnoreCase(input) || t.code.equalsIgnoreCase(input)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown Status: " + input);
    }

    @JsonValue
    public String toJson() {
        return code;
    }
}