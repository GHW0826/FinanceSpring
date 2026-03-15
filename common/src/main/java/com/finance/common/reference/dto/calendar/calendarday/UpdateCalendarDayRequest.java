package com.finance.common.reference.dto.calendar.calendarday;

public record UpdateCalendarDayRequest(
        Short isoWeekday,
        Boolean weekend,
        Boolean exception,
        Boolean businessDay,
        Integer businessDaySequence
) { }

