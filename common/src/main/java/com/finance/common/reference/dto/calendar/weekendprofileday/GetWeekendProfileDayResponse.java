package com.finance.common.reference.dto.calendar.weekendprofileday;

public record GetWeekendProfileDayResponse(
        Long weekendProfileId,
        Short isoWeekday,
        boolean weekend
) { }
