package com.finance.domain.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BizDayConv {
    MODIFIEDFOLLOWING("M"),
    FOLLOWING("F"),
    PRECEDING("P");

    private final String code;

    BizDayConv(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static BizDayConv fromJson(String input) {
        for (BizDayConv t : values()) {
            if (t.name().equalsIgnoreCase(input) || t.code.equalsIgnoreCase(input)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown BizDayConv: " + input);
    }

    @JsonValue
    public String toJson() {
        return code;
    }
}