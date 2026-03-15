package com.finance.common.reference.dto.exchange;

public record GetExchangeResponse(
        Long id,
        String exchangeCode,
        String name,
        String description
) { }

