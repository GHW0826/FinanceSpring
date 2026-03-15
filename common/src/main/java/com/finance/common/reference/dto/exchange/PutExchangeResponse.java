package com.finance.common.reference.dto.exchange;

public record PutExchangeResponse(
        Long id,
        String exchangeCode,
        String name,
        String description
) { }

