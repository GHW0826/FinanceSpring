package com.finance.domain.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CityCd {
    ENABLE("E"),
    CLOSE("C"),
    DELETED("D");

    private final String code;

    CityCd(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static CityCd fromJson(String input) {
        for (CityCd t : values()) {
            if (t.name().equalsIgnoreCase(input) || t.code.equalsIgnoreCase(input)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown CityCd: " + input);
    }

    @JsonValue
    public String toJson() {
        return code;
    }
}