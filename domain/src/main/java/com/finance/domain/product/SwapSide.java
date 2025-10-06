package com.finance.domain.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SwapSide {
    RECEIVE("R"),       // Receive
    PAY("P"),           // pay
    NONE("-");          // None

    private final String code;

    SwapSide(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static SwapSide fromJson(String input) {
        for (SwapSide t : values()) {
            if (t.name().equalsIgnoreCase(input) || t.code.equalsIgnoreCase(input)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown SwapSide: " + input);
    }

    @JsonValue
    public String toJson() {
        return code;
    }
}