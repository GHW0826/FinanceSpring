package com.finance.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ModelSect {
    FI1("FI1"),
    FI2("FI2"),
    FI3("FI3");

    private final String code;

    ModelSect(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static ModelSect fromJson(String input) {
        for (ModelSect t : values()) {
            if (t.name().equalsIgnoreCase(input) || t.code.equalsIgnoreCase(input)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown ModelSect: " + input);
    }

    @JsonValue
    public String toJson() {
        return code;
    }
}