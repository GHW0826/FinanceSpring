package com.finance.common.reference.mapper;

import com.finance.common.reference.dto.calendar.calendarweekend.*;
import com.finance.common.reference.entity.calendar.CalendarWeekend;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CalendarWeekendMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "calendar", ignore = true)
    @Mapping(target = "weekendProfile", ignore = true)
    CalendarWeekend toEntity(CreateCalendarWeekendRequest request);

    @Mapping(target = "calendarId", source = "id.calendarId")
    @Mapping(target = "validFrom", source = "id.validFrom")
    @Mapping(target = "weekendProfileId", source = "weekendProfile.id")
    CreateCalendarWeekendResponse toCreateResponse(CalendarWeekend entity);

    @Mapping(target = "calendarId", source = "id.calendarId")
    @Mapping(target = "validFrom", source = "id.validFrom")
    @Mapping(target = "weekendProfileId", source = "weekendProfile.id")
    UpdateCalendarWeekendResponse toUpdateResponse(CalendarWeekend entity);

    @Mapping(target = "calendarId", source = "id.calendarId")
    @Mapping(target = "validFrom", source = "id.validFrom")
    @Mapping(target = "weekendProfileId", source = "weekendProfile.id")
    PutCalendarWeekendResponse toPutResponse(CalendarWeekend entity);

    @Mapping(target = "calendarId", source = "id.calendarId")
    @Mapping(target = "validFrom", source = "id.validFrom")
    @Mapping(target = "weekendProfileId", source = "weekendProfile.id")
    GetCalendarWeekendResponse toGetResponse(CalendarWeekend entity);

    List<GetCalendarWeekendResponse> toGetResponseList(List<CalendarWeekend> entities);
}
