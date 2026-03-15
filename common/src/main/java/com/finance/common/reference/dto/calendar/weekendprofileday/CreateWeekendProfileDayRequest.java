package com.finance.common.reference.dto.calendar.weekendprofileday;

public record CreateWeekendProfileDayRequest(
        Long weekendProfileId,
        Short isoWeekday,
        boolean weekend
) { }
