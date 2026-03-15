package com.finance.common.reference.dto.calendar.calendarweekend;

import java.time.LocalDate;

public record UpdateCalendarWeekendRequest(
        LocalDate validTo,
        Long weekendProfileId
) { }
