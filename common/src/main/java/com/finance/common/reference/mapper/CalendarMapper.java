
package com.finance.common.reference.mapper;

import com.finance.common.reference.dto.calendar.calendar.*;
import com.finance.common.reference.entity.calendar.Calendar;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CalendarMapper {

    @Mapping(target = "country", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Calendar toEntity(CreateCalendarRequest req);

    @Mapping(target = "countryId", source = "country.id")
    CreateCalendarResponse toCreateResponse(Calendar e);

    @Mapping(target = "countryId", source = "country.id")
    UpdateCalendarResponse toUpdateResponse(Calendar e);

    @Mapping(target = "countryId", source = "country.id")
    PutCalendarResponse toPutResponse(Calendar e);

    @Mapping(target = "countryId", source = "country.id")
    GetCalendarResponse toGetResponse(Calendar e);

    @Mapping(target = "countryId", source = "country.id")
    List<GetCalendarResponse> toGetResponseList(List<Calendar> entities);
}
