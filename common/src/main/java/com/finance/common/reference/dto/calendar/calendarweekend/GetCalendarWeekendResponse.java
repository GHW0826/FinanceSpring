package com.finance.common.reference.dto.calendar.calendarweekend;

import java.time.LocalDate;

public record GetCalendarWeekendResponse(
        Long calendarId,
        LocalDate validFrom,
        LocalDate validTo,
        Long weekendProfileId
) { }
