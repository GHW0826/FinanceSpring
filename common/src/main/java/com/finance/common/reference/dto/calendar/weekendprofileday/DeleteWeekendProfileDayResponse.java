package com.finance.common.reference.dto.calendar.weekendprofileday;

public record DeleteWeekendProfileDayResponse(
        Long weekendProfileId,
        Short isoWeekday,
        boolean deleted
) { }
