package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 HOLIDAY,         // 일반 공휴일(비영업)
 SPECIAL_CLOSURE, // 임시 휴장/휴무(비영업)
 WORKING_DAY,     // 원래 비영업(주말 등)인데 영업일로 지정
 EARLY_CLOSE,     // 조기 마감(영업일이지만 세션 단축)
 LATE_OPEN,       // 지연 개장
 EMERGENCY        // 재난/긴급
 */
/**
 * 캘린더 예외 타입 (휴일/임시휴장/주말근무 등)
 */
public enum CalendarExceptionType {
    HOLIDAY("Holiday"),
    SPECIAL_CLOSURE("SpecialClosure"),
    WORKING_DAY("WorkingDay"),
    EARLY_CLOSE("EarlyClose"),
    LATE_OPEN("LateOpen"),
    EMERGENCY("Emergency");

    private final String code;

    CalendarExceptionType(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static CalendarExceptionType fromJson(String input) {
        for (CalendarExceptionType t : values()) {
            if (t.code.equalsIgnoreCase(input) || t.name().equalsIgnoreCase(input))
                return t;
        }
        throw new IllegalArgumentException("Unknown CalendarExceptionType: " + input);
    }

    @JsonValue
    public String toJson() { return code; }
}
