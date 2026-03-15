package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 COUNTRY_PUBLIC, // 국가 공휴일(공공 기준)
 BANK,           // 은행 영업일 기준
 EXCHANGE,       // 거래소 개장일 기준
 REGION,         // 국가 내 지역/주 단위
 CUSTOM          // 사내 커스텀
 */
/**
 * 캘린더 분류 (용도/소유 기준)
 */
public enum CalendarType {
    COUNTRYPUBLIC("CountryPublic"),
    BANK("Bank"),
    EXCHANGE("Exchange"),
    REGION("Region"),
    CUSTOM("Custom");

    private final String code;

    CalendarType(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static CalendarType fromJson(String input) {
        for (CalendarType t : values()) {
            if (t.code.equalsIgnoreCase(input) || t.name().equalsIgnoreCase(input))
                return t;
        }
        throw new IllegalArgumentException("Unknown CalendarType: " + input);
    }

    @JsonValue
    public String toJson() { return code; }
}
