package com.finance.common.reference.dto.calendar.weekendprofileday;

public record PutWeekendProfileDayResponse(
        Long weekendProfileId,
        Short isoWeekday,
        boolean weekend
) { }
