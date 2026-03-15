
package com.finance.common.reference.mapper;

import com.finance.common.reference.dto.calendar.calendar.*;
import com.finance.common.reference.dto.calendar.calendarset.*;
import com.finance.common.reference.entity.calendar.Calendar;
import com.finance.common.reference.entity.calendar.CalendarSet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CalendarSetMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CalendarSet toEntity(CreateCalendarSetRequest req);
    CreateCalendarSetResponse toCreateResponse(CalendarSet e);
    UpdateCalendarSetResponse toUpdateResponse(CalendarSet e);
    PutCalendarSetResponse toPutResponse(CalendarSet e);
    GetCalendarSetResponse toGetResponse(CalendarSet e);
    List<GetCalendarSetResponse> toGetResponseList(List<CalendarSet> entities);
}
