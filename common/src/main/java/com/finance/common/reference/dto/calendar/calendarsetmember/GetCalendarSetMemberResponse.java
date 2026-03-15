package com.finance.common.reference.dto.calendar.calendarsetmember;

public record GetCalendarSetMemberResponse(
        Long calendarSetId,
        Long calendarId,
        int seqNo
) { }
