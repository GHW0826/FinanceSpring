package com.finance.common.reference.dto.exchange;

public record CreateExchangeResponse(
        Long id,
        String exchangeCode,
        String name,
        String description
) { }

