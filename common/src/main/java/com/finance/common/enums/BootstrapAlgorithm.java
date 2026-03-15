package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/*
    SEQUENTIAL,   // 순차 부트스트랩
    MULTI_CURVE   // 다중 커브(할인/투영 분리)
 */
public enum BootstrapAlgorithm {
    SEQUENTIAL("Sequential"),
    MULTI_CURVE("MultiCurve");

    private final String code;

    BootstrapAlgorithm(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static BootstrapAlgorithm fromJson(String input) {
        for (BootstrapAlgorithm t : values()) {
            if (t.name().equalsIgnoreCase(input) || t.code.equalsIgnoreCase(input)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown CurveType: " + input);
    }

    @JsonValue
    public String toJson() {
        return code;
    }
}