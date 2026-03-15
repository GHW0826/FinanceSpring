package com.finance.common.reference.mapper;

import com.finance.common.reference.dto.calendar.weekendprofileday.*;
import com.finance.common.reference.entity.calendar.WeekendProfileDay;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WeekendProfileDayMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "weekendProfile", ignore = true)
    WeekendProfileDay toEntity(CreateWeekendProfileDayRequest request);

    @Mapping(target = "weekendProfileId", source = "id.weekendProfileId")
    @Mapping(target = "isoWeekday", source = "id.isoWeekday")
    CreateWeekendProfileDayResponse toCreateResponse(WeekendProfileDay entity);

    @Mapping(target = "weekendProfileId", source = "id.weekendProfileId")
    @Mapping(target = "isoWeekday", source = "id.isoWeekday")
    UpdateWeekendProfileDayResponse toUpdateResponse(WeekendProfileDay entity);

    @Mapping(target = "weekendProfileId", source = "id.weekendProfileId")
    @Mapping(target = "isoWeekday", source = "id.isoWeekday")
    PutWeekendProfileDayResponse toPutResponse(WeekendProfileDay entity);

    @Mapping(target = "weekendProfileId", source = "id.weekendProfileId")
    @Mapping(target = "isoWeekday", source = "id.isoWeekday")
    GetWeekendProfileDayResponse toGetResponse(WeekendProfileDay entity);

    List<GetWeekendProfileDayResponse> toGetResponseList(List<WeekendProfileDay> entities);
}
