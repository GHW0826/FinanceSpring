package com.finance.common.reference.dto.calendar.calendarsetmember;

public record CreateCalendarSetMemberResponse(
        Long calendarSetId,
        Long calendarId,
        int seqNo
) { }
