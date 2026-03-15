package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/*
    FLAT_ZERO,  // 마지막 제로 고정
    FLAT_FWD    // 마지막 포워드 고정(장기 외삽에서 자주 사용)
 */
public enum ExtrapolationMethod {
    FLAT_ZERO("FlatZero"),
    FLAT_FWD("FlatFwd");

    private final String code;

    ExtrapolationMethod(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static ExtrapolationMethod fromJson(String input) {
        for (ExtrapolationMethod t : values()) {
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