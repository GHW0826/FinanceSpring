package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/*

OK // 정상
EXTRAPOLATED // 외삽 구간
NON_MONOTONIC_DF // DF 단조성 위반(예: 만기가 늘었는데 DF가 커짐)
NEGATIVE_DF // DF가 0 이하 등 비정상
OUTLIER // 이상치(Outlier)
*/

/**
 * 산출 포인트 품질 플래그.
 * - DF 음수, 단조성 위반 등 QC 결과를 기록한다.
 */
public enum BondCurvePointQuality {
    OK("Ok"),
    EXTRAPOLATED("Extrapolated"),
    NON_MONOTONIC_DF("NonMonotonicDF"),
    NEGATIVE_DF("NegativeDF"),
    OUTLIER("Outlier");

    private final String code;

    BondCurvePointQuality(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static BondCurvePointQuality fromJson(String input) {
        for (BondCurvePointQuality t : values()) {
            if (t.name().equalsIgnoreCase(input) || t.code.equalsIgnoreCase(input)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown BusinessDayConvention: " + input);
    }

    @JsonValue
    public String toJson() {
        return code;
    }
}