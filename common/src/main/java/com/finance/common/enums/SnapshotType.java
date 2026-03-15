package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/*
    EOD,            // 장마감(EOD)
    INTRADAY,       // 장중
    OFFICIAL_CLOSE, // 공식 종가(거래소/공식벤더)
    INDICATIVE      // 인디케이티브(참고치)
 */
public enum SnapshotType {
    EOD("EOD"),
    INTRADAY("Intraday"),
    OFFICIAL_CLOSE("OfficialClose"),
    INDICATIVE("Indicative");

    private final String code;

    SnapshotType(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static SnapshotType fromJson(String input) {
        for (SnapshotType t : values()) {
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