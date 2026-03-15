package com.finance.common.reference.dto.calendar.calendarday;

import java.time.LocalDate;

public record GetCalendarDayRequest(
        Long calendarId,
        LocalDate dayDate
) { }

