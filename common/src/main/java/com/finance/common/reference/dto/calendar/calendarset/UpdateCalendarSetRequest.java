package com.finance.common.reference.dto.calendar.calendarset;

import com.finance.common.enums.CalendarJoinRule;

public record UpdateCalendarSetRequest(
        String setCode,
        CalendarJoinRule joinRule,
        String description
) { }
