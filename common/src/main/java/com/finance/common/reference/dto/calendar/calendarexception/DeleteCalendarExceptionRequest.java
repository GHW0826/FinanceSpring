package com.finance.common.reference.dto.calendar.calendarexception;

import java.time.LocalDate;

public record DeleteCalendarExceptionRequest(
        Long calendarId,
        LocalDate exceptionDate
) { }
