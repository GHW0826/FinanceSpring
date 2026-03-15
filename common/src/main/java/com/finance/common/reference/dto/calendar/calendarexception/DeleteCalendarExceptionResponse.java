package com.finance.common.reference.dto.calendar.calendarexception;

import java.time.LocalDate;

public record DeleteCalendarExceptionResponse(
        Long calendarId,
        LocalDate exceptionDate,
        boolean deleted
) {
}
