package com.finance.common.reference.dto.exchange;

public record UpdateExchangeRequest(
        String exchangeCode,
        String name,
        String description
) { }

