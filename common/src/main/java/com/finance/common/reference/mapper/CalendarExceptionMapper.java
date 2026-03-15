
package com.finance.common.reference.mapper;

import com.finance.common.reference.dto.calendar.calendarexception.*;
import com.finance.common.reference.entity.calendar.CalendarException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CalendarExceptionMapper {

    @Mapping(target = "calendar", ignore = true)
    @Mapping(target = "calendarExceptionId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CalendarException toEntity(CreateCalendarExceptionRequest req);

    @Mapping(target = "calendarId", source = "calendarExceptionId.calendarId")
    @Mapping(target = "exceptionDate", source = "calendarExceptionId.exceptionDate")
    CreateCalendarExceptionResponse toCreateResponse(CalendarException e);

    @Mapping(target = "calendarId", source = "calendarExceptionId.calendarId")
    @Mapping(target = "exceptionDate", source = "calendarExceptionId.exceptionDate")
    UpdateCalendarExceptionResponse toUpdateResponse(CalendarException e);

    @Mapping(target = "calendarId", source = "calendarExceptionId.calendarId")
    @Mapping(target = "exceptionDate", source = "calendarExceptionId.exceptionDate")
    PutCalendarExceptionResponse toPutResponse(CalendarException e);

    @Mapping(target = "calendarId", source = "calendarExceptionId.calendarId")
    @Mapping(target = "exceptionDate", source = "calendarExceptionId.exceptionDate")
    GetCalendarExceptionResponse toGetResponse(CalendarException e);

    List<GetCalendarExceptionResponse> toGetResponseList(List<CalendarException> entities);
}
