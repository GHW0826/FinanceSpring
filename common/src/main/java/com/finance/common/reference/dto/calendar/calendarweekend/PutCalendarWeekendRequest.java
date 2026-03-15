package com.finance.common.reference.dto.calendar.calendarweekend;

import java.time.LocalDate;

public record PutCalendarWeekendRequest(
        LocalDate validTo,
        Long weekendProfileId
) { }
