package com.finance.common.enums.domain.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
    ENABLE("E"),
    CLOSE("C"),
    DELETED("D");

    private final String code;

    Status(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static Status fromJson(String input) {
        for (Status t : values()) {
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