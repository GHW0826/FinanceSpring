package com.finance.common.reference.dto.exchange;

public record CreateExchangeRequest(
        String exchangeCode,
        String name,
        String description
) { }

