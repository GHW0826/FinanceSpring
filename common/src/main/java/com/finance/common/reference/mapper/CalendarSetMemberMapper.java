package com.finance.common.reference.mapper;

import com.finance.common.reference.dto.calendar.calendarsetmember.*;
import com.finance.common.reference.entity.calendar.CalendarSetMember;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CalendarSetMemberMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "calendarSet", ignore = true)
    @Mapping(target = "calendar", ignore = true)
    CalendarSetMember toEntity(CreateCalendarSetMemberRequest request);

    @Mapping(target = "calendarSetId", source = "id.calendarSetId")
    @Mapping(target = "calendarId", source = "id.calendarId")
    CreateCalendarSetMemberResponse toCreateResponse(CalendarSetMember entity);

    @Mapping(target = "calendarSetId", source = "id.calendarSetId")
    @Mapping(target = "calendarId", source = "id.calendarId")
    UpdateCalendarSetMemberResponse toUpdateResponse(CalendarSetMember entity);

    @Mapping(target = "calendarSetId", source = "id.calendarSetId")
    @Mapping(target = "calendarId", source = "id.calendarId")
    PutCalendarSetMemberResponse toPutResponse(CalendarSetMember entity);

    @Mapping(target = "calendarSetId", source = "id.calendarSetId")
    @Mapping(target = "calendarId", source = "id.calendarId")
    GetCalendarSetMemberResponse toGetResponse(CalendarSetMember entity);

    List<GetCalendarSetMemberResponse> toGetResponseList(List<CalendarSetMember> entities);
}
