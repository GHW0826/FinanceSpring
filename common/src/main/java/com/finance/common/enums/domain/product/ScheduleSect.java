package com.finance.common.enums.domain.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ScheduleSect {
    Interest("Interest"),
    Maturity("Maturity");

    private final String code;

    ScheduleSect(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static ScheduleSect fromJson(String input) {
        for (ScheduleSect t : values()) {
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