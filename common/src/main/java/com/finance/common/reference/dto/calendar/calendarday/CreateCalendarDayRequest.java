package com.finance.common.reference.dto.calendar.calendarday;

import java.time.LocalDate;

public record CreateCalendarDayRequest(
        Long calendarId,
        LocalDate dayDate,
        Short isoWeekday,
        Boolean weekend,
        Boolean exception,
        Boolean businessDay,
        Integer businessDaySequence
) { }

