package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/*
    DISCOUNTING,  // 할인(DF) 계산용
    PROJECTION,   // 현금흐름/지수 예측(Forward)용
    BENCHMARK,    // 벤치마크(수익률 비교)용
    SPREAD        // 스프레드(가산금리) 자체를 담는 커브
 */
public enum CurvePurpose {
    DISCOUNTING("Discounting"),
    PROJECTION("Projection"),
    BENCHMARK("Benchmark"),
    SPREAD("Spread");

    private final String code;

    CurvePurpose(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static CurvePurpose fromJson(String input) {
        for (CurvePurpose t : values()) {
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