package com.finance.common.market.mapper.bond;

import com.finance.common.market.dto.bond.CreateMarketBondRequest;
import com.finance.common.market.dto.bond.CreateMarketBondResponse;
import com.finance.common.market.entity.MarketDataBondMaster;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface MarketDataBondMapper {

    // Request(record) -> Entity
    @Mapping(source = "MarketDataCode", target = "marketDataCode")
    @Mapping(source = "Name",           target = "name")
    @Mapping(source = "IssuerCode",     target = "issuerCode")
    @Mapping(source = "ISINCode",       target = "isinCode")              // ✅ 여기 수정 포인트
    @Mapping(source = "ListingSection", target = "listingSection")
    @Mapping(source = "InterestPayMethod", target = "interestPayMethod")
    @Mapping(source = "AssetSecuritizationClassification", target = "assetSecuritizationClassification")
    @Mapping(source = "SubordinationClassification",       target = "subordinationClassification")
    @Mapping(source = "IssueDate",      target = "issueDate")
    @Mapping(source = "MaturityDate",   target = "maturityDate")
    @Mapping(source = "OriginSourceCode", target = "originSourceCode")
    @Mapping(source = "IssueKind",      target = "issueKind")
    @Mapping(source = "IssuePurpose",   target = "issuePurpose")
    @Mapping(source = "Description",    target = "description")

    // DTO에 없으니 서비스에서 채움 (JPA not-null 관계면 특히 필수)
    @Mapping(target = "currency", ignore = true)
    @Mapping(target = "sourceCode", ignore = true)
    MarketDataBondMaster toEntity(CreateMarketBondRequest req);

    // Entity -> Response
    // Response 필드명이 entity와 같으면 MapStruct가 자동 매핑 가능
    CreateMarketBondResponse toResponse(MarketDataBondMaster entity);

    // PATCH/UPDATE용: null 값은 덮어쓰지 않기
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "currency", ignore = true)
    @Mapping(target = "sourceCode", ignore = true)
    void updateEntity(CreateMarketBondRequest req, @MappingTarget MarketDataBondMaster entity);
}