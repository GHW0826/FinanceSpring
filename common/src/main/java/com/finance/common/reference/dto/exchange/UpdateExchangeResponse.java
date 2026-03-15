package com.finance.common.reference.dto.exchange;

public record UpdateExchangeResponse(
        Long id,
        String exchangeCode,
        String name,
        String description
) { }

