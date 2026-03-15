package com.finance.common.reference.dto.calendar.weekendprofileday;

public record CreateWeekendProfileDayResponse(
        Long weekendProfileId,
        Short isoWeekday,
        boolean weekend
) { }
