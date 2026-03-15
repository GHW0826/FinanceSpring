package com.finance.common.reference.dto.calendar.calendarexception;

import com.finance.common.enums.CalendarExceptionType;

import java.time.LocalDate;

public record UpdateCalendarExceptionRequest(
        Boolean businessDay,
        CalendarExceptionType exceptionType,
        String exceptionName,
        LocalDate observedOf,
        String source
) { }
