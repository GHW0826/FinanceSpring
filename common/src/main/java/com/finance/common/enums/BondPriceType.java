package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/*
    CLEAN // Clean Price(경과이자 제외)
    DIRTY // Clean Price(경과이자 제외)
 */

/**
 * 가격 입력이 Clean인지 Dirty인지 구분한다.
 */
public enum BondPriceType {
    CLEAN("Clean"),
    DIRTY("Dirty");

    private final String code;

    BondPriceType(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static BondPriceType fromJson(String input) {
        for (BondPriceType t : values()) {
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