package com.finance.common.reference.dto.calendar.calendarweekend;

import java.time.LocalDate;

public record CreateCalendarWeekendRequest(
        Long calendarId,
        LocalDate validFrom,
        LocalDate validTo,
        Long weekendProfileId
) { }
