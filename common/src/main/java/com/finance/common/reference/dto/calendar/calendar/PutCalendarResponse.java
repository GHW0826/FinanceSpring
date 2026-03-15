package com.finance.common.reference.dto.calendar.calendar;

import com.finance.common.enums.CalendarType;

public record PutCalendarResponse(
        Long id,
        String calendarCode,
        String calendarName,
        CalendarType calendarType,
        Long countryId,
        String regionCode,
        String timezone,
        boolean active
) { }