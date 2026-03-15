package com.finance.common.reference.dto.exchange;

public record PutExchangeRequest(
        String exchangeCode,
        String name,
        String description
) { }

