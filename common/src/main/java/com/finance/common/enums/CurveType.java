package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/*
    GOVERNMENT,          // 국채/정부 벤치마크 커브
    OIS,           // OIS 할인 커브
    IRS,           // IRS(IBOR/Term) 투영/벤치마크 커브
    CREDIT_SPREAD, // 크레딧 스프레드 커브(국채 대비 등)
    INFLATION      // 물가/BEI 관련 커브
 */
public enum CurveType {
    GOVERNMENT("Government"),
    OIS("OIS"),
    IRS("IRS"),
    AGENCY("Agency"),
    CORPORATE("Corporate"),
    BOND_SPREAD("BondSpread"),
    CREDITSPREAD("CreditSpread"),
    INFLATION("Inflation");

    private final String code;

    CurveType(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static CurveType fromJson(String input) {
        for (CurveType t : values()) {
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