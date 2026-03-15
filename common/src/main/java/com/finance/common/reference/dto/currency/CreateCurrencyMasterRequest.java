package com.finance.common.reference.dto.currency;

public record CreateCurrencyMasterRequest(
        String currencyCode,
        String name,
        String description
) { }