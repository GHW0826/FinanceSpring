package com.finance.common.reference.dto.calendar.calendarsetmember;

public record UpdateCalendarSetMemberResponse(
        Long calendarSetId,
        Long calendarId,
        int seqNo
) { }
