package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/*
    INTERNAL,     // 내부(데스크/팀/계열 포함 가능 - 필요시 세분화)
    EXTERNAL,     // 외부
    AFFILIATE,    // 계열사(내부거래/연결회계 등에서 의미 있음)
    CCP,          // CCP/청산소
    GOVERNMENT    // 정부/중앙은행 등
 */
public enum CounterpartyType {
    INTERNAL("Internal"),
    EXTERNAL("External"),
    AFFILIATE("Affiliate"),
    CCP("CCP"),
    GOVERNMENT("Government");

    private final String code;

    CounterpartyType(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static CounterpartyType fromJson(String input) {
        for (CounterpartyType t : values()) {
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