package com.finance.common.reference.dto.calendar.calendarday;

public record PutCalendarDayRequest(
        Short isoWeekday,
        Boolean weekend,
        Boolean exception,
        Boolean businessDay,
        Integer businessDaySequence
) { }

