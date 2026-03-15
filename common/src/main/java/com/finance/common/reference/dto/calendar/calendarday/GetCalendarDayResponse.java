package com.finance.common.reference.dto.calendar.calendarday;

import java.time.LocalDate;

public record GetCalendarDayResponse(
        Long calendarId,
        LocalDate dayDate,
        Short isoWeekday,
        boolean weekend,
        boolean exception,
        boolean businessDay,
        int businessDaySequence
) { }

