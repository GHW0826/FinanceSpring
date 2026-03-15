package com.finance.common.reference.dto.calendar.calendarday;

import java.time.LocalDate;

public record CreateCalendarDayResponse(
        Long calendarId,
        LocalDate dayDate,
        Short isoWeekday,
        boolean weekend,
        boolean exception,
        boolean businessDay,
        int businessDaySequence
) { }

