package com.finance.common.market.dto.marketmaster;

public record PutMarketMasterRequest(
        String marketCode,
        Long vendorId,
        String name,
        Long currencyId,
        Long defaultTradingContextId,
        Long defaultValuationContextId,
        String description
) { }


