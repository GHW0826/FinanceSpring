package com.finance.common.reference.dto.calendar.calendarday;

import java.time.LocalDate;

public record DeleteCalendarDayResponse(
        Long calendarId,
        LocalDate dayDate,
        boolean deleted
) { }

