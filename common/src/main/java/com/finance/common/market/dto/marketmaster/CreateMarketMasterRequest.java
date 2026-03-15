package com.finance.common.market.dto.marketmaster;

public record CreateMarketMasterRequest(
        String marketCode,
        Long vendorId,
        String name,
        Long currencyId,
        Long defaultTradingContextId,
        Long defaultValuationContextId,
        String description
) { }


