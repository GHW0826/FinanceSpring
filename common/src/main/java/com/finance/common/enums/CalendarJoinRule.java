package com.finance.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 조합 캘린더 결합 규칙
 * - JOIN_HOLIDAYS: 구성원 중 하나라도 휴일이면 휴일 (business-day는 교집합 성격)
 * - JOIN_BUSINESS_DAYS: 구성원 중 하나라도 영업일이면 영업일 (business-day는 합집합 성격)
 */
public enum CalendarJoinRule {
    JOIN_HOLIDAYS("JoinHolidays"),
    JOIN_BUSINESS_DAYS("JoinBusinessDays");

    private final String code;

    CalendarJoinRule(String code) { this.code = code; }
    public String getCode() { return code; }

    @JsonCreator
    public static CalendarJoinRule fromJson(String input) {
        for (CalendarJoinRule t : values()) {
            if (t.code.equalsIgnoreCase(input) || t.name().equalsIgnoreCase(input))
                return t;
        }
        throw new IllegalArgumentException("Unknown CalendarExceptionType: " + input);
    }

    @JsonValue
    public String toJson() { return code; }
}
