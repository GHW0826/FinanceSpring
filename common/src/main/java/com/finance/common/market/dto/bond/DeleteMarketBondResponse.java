package com.finance.common.market.dto.bond;

public record DeleteMarketBondResponse(
        String marketCode,
        boolean deleted
) { }
