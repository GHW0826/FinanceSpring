package com.finance.common.reference.mapper;

import com.finance.common.reference.dto.currency.*;
import com.finance.common.reference.entity.CurrencyMaster;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CurrencyMasterMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CurrencyMaster toEntity(CreateCurrencyMasterRequest req);

    CreateCurrencyMasterResponse toCreateResponse(CurrencyMaster e);
    UpdateCurrencyMasterResponse toUpdateResponse(CurrencyMaster e);
    PutCurrencyMasterResponse toPutResponse(CurrencyMaster e);
    GetCurrencyMasterResponse toGetResponse(CurrencyMaster e);
    List<GetCurrencyMasterResponse> toGetResponseList(List<CurrencyMaster> entities);
}
