package com.finance.common.reference.dto.calendar.calendar;

import com.finance.common.enums.CalendarType;

public record CreateCalendarRequest(
        String calendarCode,
        String calendarName,
        CalendarType calendarType,
        Long countryId,
        String regionCode,
        String timezone,
        Boolean active
) { }
