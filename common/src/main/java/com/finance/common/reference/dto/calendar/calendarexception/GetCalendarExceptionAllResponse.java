package com.finance.common.reference.dto.calendar.calendarexception;

import java.util.List;

public record GetCalendarExceptionAllResponse(
        List<GetCalendarExceptionResponse> items
) { }