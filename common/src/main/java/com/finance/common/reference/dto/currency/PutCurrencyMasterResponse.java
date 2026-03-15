package com.finance.common.reference.dto.currency;

public record PutCurrencyMasterResponse(
        Long id,
        String currencyCode,
        String name,
        String description
) { }