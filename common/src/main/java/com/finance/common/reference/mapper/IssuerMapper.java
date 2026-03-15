
package com.finance.common.reference.mapper;

import com.finance.common.reference.dto.Issuer.*;
import com.finance.common.reference.entity.Issuer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IssuerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "country", ignore = true)
    @Mapping(target = "parentIssuer", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Issuer toEntity(CreateIssuerRequest req);

    @Mapping(target = "issuerId", source = "id")
    @Mapping(target = "countryId", source = "country.id")
    @Mapping(target = "parentIssuerId", source = "parentIssuer.id")
    CreateIssuerResponse toCreateResponse(Issuer e);

    @Mapping(target = "issuerId", source = "id")
    @Mapping(target = "countryId", source = "country.id")
    @Mapping(target = "parentIssuerId", source = "parentIssuer.id")
    UpdateIssuerResponse toUpdateResponse(Issuer e);

    @Mapping(target = "issuerId", source = "id")
    @Mapping(target = "countryId", source = "country.id")
    @Mapping(target = "parentIssuerId", source = "parentIssuer.id")
    GetIssuerResponse toGetResponse(Issuer e);

    @Mapping(target = "issuerId", source = "id")
    @Mapping(target = "countryId", source = "country.id")
    @Mapping(target = "parentIssuerId", source = "parentIssuer.id")
    PutIssuerResponse toPutResponse(Issuer e);

    List<GetIssuerResponse> toGetResponseList(List<Issuer> entities);
}