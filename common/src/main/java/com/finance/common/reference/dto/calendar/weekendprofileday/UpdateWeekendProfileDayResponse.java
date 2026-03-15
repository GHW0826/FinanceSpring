package com.finance.common.reference.dto.calendar.weekendprofileday;

public record UpdateWeekendProfileDayResponse(
        Long weekendProfileId,
        Short isoWeekday,
        boolean weekend
) { }
