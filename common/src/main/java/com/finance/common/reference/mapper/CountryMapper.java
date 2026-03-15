
package com.finance.common.reference.mapper;

import com.finance.common.reference.dto.country.*;
import com.finance.common.reference.entity.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Country toEntity(CreateCountryRequest req);
    CreateCountryResponse toCreateResponse(Country e);
    UpdateCountryResponse toUpdateResponse(Country e);
    PutCountryResponse toPutResponse(Country e);
    GetCountryResponse toGetResponse(Country e);
    List<GetCountryResponse> toGetResponseList(List<Country> entities);
}
