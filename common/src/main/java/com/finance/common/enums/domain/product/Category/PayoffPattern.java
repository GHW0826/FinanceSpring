package com.finance.common.enums.domain.product.Category;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PayoffPattern {
    ZeroCoupon("ZeroCoupon"),
    CFS("CFS"),
    CFG("CFG"),
    CFB("CFB"),
    CFA("CFA"),
    CFD("CFD"),
    CFR("CFR"),
    STD("STD"),
    BAR("BAR"),
    FWD("FWD"),
    LAD("LAD"),
    RAT("RAT"),
    BIN("BIN"),
    TCH("TCH"),
    HFL("HFL"),
    HAC("HAC"),
    FIR("FIR"),
    FLR("FLR"),
    CUF("CUF"),
    ACR("ACR"),
    ACF("ACF"),
    CUA("CUA"),
    VOL("VOL"),
    VNL("VNL"),
    RFR("RFR"),
    ACB("ACB"),
    ACC("ACC"),
    ASN("ASN"),
    LBK("LBK"),
    RBW("RBW"),
    WNT("WNT");

    private final String code;

    PayoffPattern(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @JsonCreator
    public static PayoffPattern fromJson(String input) {
        for (PayoffPattern t : values()) {
            if (t.name().equalsIgnoreCase(input) || t.code.equalsIgnoreCase(input)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown PayoffPattern: " + input);
    }

    @JsonValue
    public String toJson() {
        return code;
    }
}