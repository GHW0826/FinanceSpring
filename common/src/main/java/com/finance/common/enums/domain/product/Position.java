package com.finance.common.enums.domain.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Position {
    BUY("B"),           // Long
    SELL("S");          // Short

    private final String code;

    Position(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static Position fromJson(String input) {
        for (Position t : values()) {
            if (t.name().equalsIgnoreCase(input) || t.code.equalsIgnoreCase(input)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown Position: " + input);
    }

    @JsonValue
    public String toJson() {
        return code;
    }
}