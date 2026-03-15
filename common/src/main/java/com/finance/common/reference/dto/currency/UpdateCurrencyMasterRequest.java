package com.finance.common.reference.dto.currency;

public record UpdateCurrencyMasterRequest(
        String currencyCode,
        String name,
        String description
) { }