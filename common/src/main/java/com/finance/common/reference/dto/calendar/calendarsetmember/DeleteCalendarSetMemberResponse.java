package com.finance.common.reference.dto.calendar.calendarsetmember;

public record DeleteCalendarSetMemberResponse(
        Long calendarSetId,
        Long calendarId,
        boolean deleted
) { }
