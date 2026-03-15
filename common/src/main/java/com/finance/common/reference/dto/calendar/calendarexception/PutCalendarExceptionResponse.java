package com.finance.common.reference.dto.calendar.calendarexception;

import com.finance.common.enums.CalendarExceptionType;

import java.time.LocalDate;

public record PutCalendarExceptionResponse(
        Long calendarId,
        LocalDate exceptionDate,
        boolean businessDay,
        CalendarExceptionType exceptionType,
        String exceptionName,
        LocalDate observedOf,
        String source
) { }