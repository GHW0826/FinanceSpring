package com.finance.common.enums.domain.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BusinessSect {
    Preparing("Preparing"),             // 업무 준비
    Open("Open"),                       // 업무 진행중
    ClosePreParing("ClosePreparing"),   // 업무 마감 준비
    Closed("Closed"),                   // 업무 마감
    CloseRequested("CloseRequested");   // 업무 마감 요청

    private final String code;

    BusinessSect(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static BusinessSect fromJson(String input) {
        for (BusinessSect t : values()) {
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