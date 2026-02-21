package com.finance.common.common.mapper.currency;

import com.finance.common.common.dto.currency.CreateCurrencyRequest;
import com.finance.common.common.dto.currency.CreateCurrencyResponse;
import com.finance.common.common.dto.currency.GetCurrencyResponse;
import com.finance.common.common.entity.currency.CurrencyMaster;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CurrencyMasterMapper {

    // Request(record: Ccy/Description) -> Entity(property: ccy/description)
    @Mapping(source = "Ccy",         target = "ccy")
    @Mapping(source = "Description", target = "description")
    CurrencyMaster toEntity(CreateCurrencyRequest req);

    // Entity -> Response
    @Mapping(source = "ccy",         target = "Ccy")
    @Mapping(source = "description", target = "Description")
    CreateCurrencyResponse toCreateResponse(CurrencyMaster e);

    @Mapping(source = "ccy",         target = "Ccy")
    @Mapping(source = "description", target = "Description")
    GetCurrencyResponse toGetResponse(CurrencyMaster e);
}