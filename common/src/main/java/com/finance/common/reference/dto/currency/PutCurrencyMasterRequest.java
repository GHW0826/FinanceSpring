package com.finance.common.reference.dto.currency;

public record PutCurrencyMasterRequest(
        String currencyCode,
        String name,
        String description
) { }