package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/*
    SIMPLE, // 단리 
    COMPOUNDED, // 복리
    CONTINUOUS // 연속복리
 */
public enum CompoundingType {
    SIMPLE("Simple"),
    COMPOUNDED("Compounded"),
    CONTINUOUS("Continuous");

    private final String code;

    CompoundingType(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static CompoundingType fromJson(String input) {
        for (CompoundingType t : values()) {
            if (t.name().equalsIgnoreCase(input) || t.code.equalsIgnoreCase(input)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown InterpolationMethod: " + input);
    }

    @JsonValue
    public String toJson() {
        return code;
    }
}