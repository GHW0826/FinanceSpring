package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/*
    LINEAR_ZERO,     // 제로금리(Zero Rate)를 선형 보간
    LOGLINEAR_DF,    // 할인계수(DF)를 로그-선형 보간(실무에서 매우 흔함)
    CUBIC_SPLINE_ZERO // 제로금리 스플라인 보간(곡선 매끈하게)
 */
public enum InterpolationMethod {
    LINEAR_ZERO("LinearZero"),
    LOGLINEAR_DF("LoglinearDF"),
    CUBIC_SPLINE_ZERO("CubicSplineZero");

    private final String code;

    InterpolationMethod(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static InterpolationMethod fromJson(String input) {
        for (InterpolationMethod t : values()) {
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