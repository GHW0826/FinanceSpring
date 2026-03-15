package com.finance.common.enums.domain.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


public enum SettleSect {
    PHYSICALDELIVERY("P"),      // 실물인수도
    CASHSETTLEMENT("C");        // 현금결제

    private final String code;

    SettleSect(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static SettleSect fromJson(String input) {
        for (SettleSect t : values()) {
            if (t.name().equalsIgnoreCase(input) || t.code.equalsIgnoreCase(input)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown SettleSect: " + input);
    }

    @JsonValue
    public String toJson() {
        return code;
    }
}