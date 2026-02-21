package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ListingSection {
    Listed("Listed"),           // 상장
    Nonlisted("Nonlisted"),     // 비상장
    Other("Other"),             // 기타 (예: 분류 불가, 별도시장/특수케이스, 데이터 미정 등)
    Called("Called");           // 상장폐지(상환조치)

    private final String code;

    ListingSection(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static ListingSection fromJson(String input) {
        for (ListingSection t : values()) {
            if (t.name().equalsIgnoreCase(input) || t.code.equalsIgnoreCase(input)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown ListingSection: " + input);
    }

    @JsonValue
    public String toJson() {
        return code;
    }
}