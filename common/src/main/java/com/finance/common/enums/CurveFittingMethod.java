package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/*
    BOOTSTRAP // 입력을 사용해 구간별로 부트스트랩(가능한 경우)
    SPLINE_FIT // 스플라인 기반 피팅(대표적)
    NELSON_SIEGEL // Nelson-Siegel 파라메트릭 피팅
    SVENSSON // Svensson 파라메트릭 피팅(확장형)
*/
/**
 * 채권 커브 산출 방식(피팅/부트스트랩 등)을 나타낸다.
 * - 입력이 가격/수익률이므로, 부드러운 커브 피팅이 필요한 경우가 많다.
 */
public enum CurveFittingMethod {
    BOOTSTRAP("Bootstrap"),
    SPLINE_FIT("SplineFit"),
    NELSON_SIEGEL("NelsonSiegel"),
    SVENSSON("Svensson");

    private final String code;

    CurveFittingMethod(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static CurveFittingMethod fromJson(String input) {
        for (CurveFittingMethod t : values()) {
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