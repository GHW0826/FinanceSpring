package com.finance.common.reference.dto.calendar.calendarday;

import java.time.LocalDate;

public record DeleteCalendarDayRequest(
        Long calendarId,
        LocalDate dayDate
) { }

