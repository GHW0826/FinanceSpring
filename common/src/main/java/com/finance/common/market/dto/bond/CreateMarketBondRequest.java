package com.finance.common.market.dto.bond;

import com.finance.common.enums.*;

import java.util.Date;

public record CreateMarketBondRequest (
        String MarketDataCode,
        String Name,
        String IssuerCode,
        String ISINCode,
        ListingSection ListingSection,
        String Ccy,
        String assetGroup,
        InterestPayMethod InterestPayMethod,
        AssetSecuritizationClassification AssetSecuritizationClassification,
        SubordinationClassification SubordinationClassification,
        Date IssueDate,
        Date MaturityDate,
        SourceCode OriginSourceCode,
        String IssueKind,
        String IssuePurpose,
        String Description
) { }