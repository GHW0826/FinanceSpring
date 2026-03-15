package com.finance.common.reference.dto.calendar.calendarweekend;

import java.time.LocalDate;

public record DeleteCalendarWeekendResponse(
        Long calendarId,
        LocalDate validFrom,
        boolean deleted
) { }
