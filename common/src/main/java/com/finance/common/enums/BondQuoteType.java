package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/*
    PRICE // 가격 기반 입력(예: Clean Price, Dirty Price)
    YIELD // 수익률(YTM) 기반 입력
 */

/**
 * 채권 커브 입력 노드가 "가격"인지 "수익률"인지 구분한다.
 */
public enum BondQuoteType {
    PRICE("Price"),
    YIELD("Yield");

    private final String code;

    BondQuoteType(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static BondQuoteType fromJson(String input) {
        for (BondQuoteType t : values()) {
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