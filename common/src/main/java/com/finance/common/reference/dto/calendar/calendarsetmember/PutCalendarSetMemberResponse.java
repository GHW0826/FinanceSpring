package com.finance.common.reference.dto.calendar.calendarsetmember;

public record PutCalendarSetMemberResponse(
        Long calendarSetId,
        Long calendarId,
        int seqNo
) { }
