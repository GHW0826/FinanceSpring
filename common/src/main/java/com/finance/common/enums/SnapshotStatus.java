package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/*
    PRELIMINARY, // 잠정
    FINAL,       // 확정
    STALE,       // 오래됨(갱신 안 됨)
    REJECTED     // 품질 이슈로 사용 금지
 */
public enum SnapshotStatus {
    PRELIMINARY("Preliminary"),
    FINAL("Final"),
    STALE("Stale"),
    REJECTED("Rejected");

    private final String code;

    SnapshotStatus(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static SnapshotStatus fromJson(String input) {
        for (SnapshotStatus t : values()) {
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