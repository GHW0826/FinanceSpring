package com.finance.common.reference.mapper;

import com.finance.common.reference.dto.calendar.weekendprofile.*;
import com.finance.common.reference.entity.calendar.WeekendProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WeekendProfileMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    WeekendProfile toEntity(CreateWeekendProfileRequest req);

    CreateWeekendProfileResponse toCreateResponse(WeekendProfile entity);

    UpdateWeekendProfileResponse toUpdateResponse(WeekendProfile entity);

    PutWeekendProfileResponse toPutResponse(WeekendProfile entity);

    GetWeekendProfileResponse toGetResponse(WeekendProfile entity);

    List<GetWeekendProfileResponse> toGetResponseList(List<WeekendProfile> entities);
}
